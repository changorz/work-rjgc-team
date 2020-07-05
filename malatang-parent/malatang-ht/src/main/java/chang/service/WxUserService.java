package chang.service;

import chang.pojo.WxUser;

import java.util.Map;

public interface WxUserService {
    void addWxUser(WxUser wxUser);

    WxUser findWxUserByOpenid(String openid);

    void updataWxUser(Map<String,String> map);

}
