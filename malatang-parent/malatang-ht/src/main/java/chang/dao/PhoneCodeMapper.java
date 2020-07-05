package chang.dao;

import chang.pojo.PhoneCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PhoneCodeMapper {

    void addPhoneCode(PhoneCode phoneCode);

    void addPhoneCodeList(List<PhoneCode> list);

    void upudataPhoneCode(PhoneCode phoneCode);

    void deletePhoneCodeById(int id);

    void deleteAllPhoneCode();

    int getAllPhoneCodeCount();

    List<PhoneCode> getAllPhoneCode();

    List<PhoneCode> findPhoneCodeByPage(@Param("pageStart")int pageStart,
                                        @Param("pageSize")int pageSize);


    List<PhoneCode> findPhoneCodeByName(String name);

}
