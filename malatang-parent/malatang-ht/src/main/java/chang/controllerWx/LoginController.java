package chang.controllerWx;

import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResultCode;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.pojo.WxUser;
import chang.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.spi.ResolveResult;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;

@Api(tags = "微信登录相关接口")
@RestController
@RequestMapping("/wx/login")
public class LoginController {

    @Autowired
    private WxMpService wxService;

    @Autowired
    private WxUserService wxUserService;

    /**
     * 重定向的url
     */
    @Value("${wx.mp.url}")
    private String RURL;

    /**
     * 获取授权页面的url
     * @return 返回一个url字符串
     */
    @GetMapping("/getUrl")
    @ApiOperation("获取微信登录路径")
    public String getUrl(){
        return wxService.oauth2buildAuthorizationUrl(RURL, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
    }

    @GetMapping("/getInfoUser/{code}")
    @ApiOperation("根据code获取用户信息")
    public Response getInfoUser(@PathVariable String code, HttpServletRequest resp){
        WxMpUser user = null;
        try {
            WxMpOAuth2AccessToken accessToken = wxService.oauth2getAccessToken(code);
            user = wxService.oauth2getUserInfo(accessToken, null);
            /**
             * 1. 存sinsion
             * 2. 通过openid查询
             * 3. 存在==》修改user信息，修改最后登录时间，修改登录次数
             * 4. 不存在==》插入信息
             */
            resp.getSession().setAttribute("user",user);
            String openId = user.getOpenId();
            WxUser wxUserByOpenid = wxUserService.findWxUserByOpenid(openId);
            if (wxUserByOpenid == null) {
                WxUser build = WxUser.builder()
                        .openid(user.getOpenId())
                        .nickname(user.getNickname())
                        .headImgUrl(user.getHeadImgUrl())
                        .country(user.getCountry())
                        .province(user.getProvince())
                        .city(user.getCity())
                        .sex(user.getSexDesc())
                        .logincount(0)
                        .endtimt(LocalDateTime.now())
                        .build();
                wxUserService.addWxUser(build);
                System.out.println(111);
            } else {
                HashMap<String, String> map = new HashMap<>();
                map.put("openid",user.getOpenId());
                map.put("nickname",user.getNickname());
                map.put("headImgUrl",user.getHeadImgUrl());
                map.put("country",user.getCountry());
                map.put("province",user.getProvince());
                map.put("city",user.getCity());
                map.put("sex",user.getSexDesc());
                map.put("logincount",(wxUserByOpenid.getLogincount()+1)+"");
                map.put("endtimt",LocalDateTime.now().toString());
                wxUserService.updataWxUser(map);
            }
        } catch (WxErrorException e) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return new ObjectResult(CommonCode.SUCCESS,user);
    }
}
