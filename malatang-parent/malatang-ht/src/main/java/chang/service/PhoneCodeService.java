package chang.service;

import chang.model.response.Response;
import chang.pojo.Pager;
import chang.pojo.PhoneCode;
import chang.pojo.Repair;

import java.io.InputStream;

public interface PhoneCodeService {

    Response uploadExcel(InputStream inputStream);

    Response deletePhoneCodeById(int id);

    Response addPhoneCode(PhoneCode phoneCode);

    Response upudataPhoneCode(PhoneCode phoneCode);

    Response deleteAllPhoneCode();

    Response getAllPhoneCode();

    Response findPhoneCodeByPage(Pager<PhoneCode> pager);

    Response findPhoneCodeByName(String name);

}
