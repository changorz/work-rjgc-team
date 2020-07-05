package chang.service.Impl;

import chang.dao.WxUserMapper;
import chang.pojo.WxUser;
import chang.service.WxUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class WxUserServiceImpl implements WxUserService {

    private WxUserMapper wxUserMapper;

    @Override
    public void addWxUser(WxUser wxUser) {
        wxUserMapper.addWxUser(wxUser);
    }

    @Override
    public WxUser findWxUserByOpenid(String openid) {
        return wxUserMapper.findWxUserByOpenid(openid);
    }

    @Override
    public void updataWxUser(Map<String, String> map) {
        wxUserMapper.updataWxUser(map);
    }
}
