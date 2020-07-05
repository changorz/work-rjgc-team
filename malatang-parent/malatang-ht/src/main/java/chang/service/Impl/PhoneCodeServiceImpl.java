package chang.service.Impl;

import chang.dao.PhoneCodeMapper;
import chang.listener.UploadPhoneCodeEasyExcelListener;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResponseResult;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.model.response.plus.QueryResponseResult;
import chang.model.response.plus.QueryResult;
import chang.pojo.Pager;
import chang.pojo.PhoneCode;
import chang.pojo.Repair;
import chang.service.PhoneCodeService;
import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {

    @Autowired
    private PhoneCodeMapper phoneCodeMapper;

    @Override
    public Response uploadExcel(InputStream inputStream) {
        try{
            EasyExcel.read(inputStream, PhoneCode.class, new UploadPhoneCodeEasyExcelListener(phoneCodeMapper)).sheet(0).doRead();
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.FILE_READ_ERR);
        }
        return new ResponseResult(CommonCode.FILE_READ_OK);
    }

    @Override
    public Response deletePhoneCodeById(int id) {
        phoneCodeMapper.deletePhoneCodeById(id);
        return ResponseResult.SUCCESS();
    }

    @Override
    public Response addPhoneCode(PhoneCode phoneCode) {
        if(StringUtils.isEmpty(phoneCode.getName())||StringUtils.isEmpty(phoneCode.getNumber())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        phoneCodeMapper.addPhoneCode(phoneCode);
        ObjectResult objectResult = new ObjectResult(CommonCode.SUCCESS, phoneCode);
        return objectResult;
    }

    @Override
    public Response upudataPhoneCode(PhoneCode phoneCode) {
        if(phoneCode.getId() == 0){
            return new ResponseResult(CommonCode.INVALID_PARAM);
        }
        phoneCodeMapper.upudataPhoneCode(phoneCode);
        return  ResponseResult.SUCCESS();
    }

    @Override
    public Response deleteAllPhoneCode() {
        phoneCodeMapper.deleteAllPhoneCode();
        return ResponseResult.SUCCESS();
    }

    @Override
    public Response getAllPhoneCode() {
        List<PhoneCode> allPhoneCode = phoneCodeMapper.getAllPhoneCode();
        QueryResult<PhoneCode> objectQueryResult = new QueryResult<>();
        objectQueryResult.setList(allPhoneCode);
        objectQueryResult.setTotal(allPhoneCode.size());
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }

    @Override
    public Response findPhoneCodeByPage(Pager<PhoneCode> pager) {
        int pageSize = pager.getPageSize();
        int pageStart = (pager.getPageStart() - 1) * pageSize;
        List<PhoneCode> phoneCodeByPage = phoneCodeMapper.findPhoneCodeByPage(pageStart, pageSize);
        pager.setRows(phoneCodeByPage);
        pager.setTotal(phoneCodeMapper.getAllPhoneCodeCount());
        return new ObjectResult(CommonCode.SUCCESS, pager);
    }

    @Override
    public Response findPhoneCodeByName(String name) {
        if(StringUtils.isEmpty(name)){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        List<PhoneCode> phoneCodeByName = phoneCodeMapper.findPhoneCodeByName("%" + name + "%");
        QueryResult<PhoneCode> objectQueryResult = new QueryResult<>();
        objectQueryResult.setList(phoneCodeByName);
        objectQueryResult.setTotal(phoneCodeByName.size());
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }
}
