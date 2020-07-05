package chang.dao;

import chang.pojo.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface WxUserMapper {

    void addWxUser(WxUser wxUser);

    WxUser findWxUserByOpenid(String openid);

    void updataWxUser(Map<String,String> map);

}
