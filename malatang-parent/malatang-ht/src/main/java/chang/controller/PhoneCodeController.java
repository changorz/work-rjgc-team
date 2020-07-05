package chang.controller;

import chang.listener.UploadRepairEasyExcelListener;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.myException.ExceptionCast;
import chang.pojo.Pager;
import chang.pojo.PhoneCode;
import chang.pojo.Repair;
import chang.service.PhoneCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Api(tags = "电话号码管理类")
@RequestMapping("/admin/md/phoneCode")
@RestController
public class PhoneCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadRepairEasyExcelListener.class);
    @Autowired
    private PhoneCodeService phoneCodeService;

    @ApiOperation("Excel文件上传")
    @PostMapping
    public Response uploadExcel(MultipartFile file)  {
        String name = file.getOriginalFilename();
        if (!StringUtils.isEmpty(name)){
            if (".xlsx".equals(name.substring(name.lastIndexOf("."))) || ".xls".equals(name.substring(name.lastIndexOf(".")))){
                LOGGER.info("上传文件==》{}  ok", name);
            }else{
                LOGGER.info("上传文件==》{}  err [文件格式错误]", name);
                ExceptionCast.cast(CommonCode.FILE_FILE_ERR);
            }
        } else {
            ExceptionCast.cast(CommonCode.FILE_FILE_ERR);
        }
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            return phoneCodeService.uploadExcel(inputStream);
        }catch (IOException e){
            ExceptionCast.cast(CommonCode.FILE_UPLOAD_ERR);
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @PostMapping("add")
    @ApiOperation("添加一个电话号码")
    public Response addPhoneCode(@RequestBody PhoneCode phoneCode){
        return phoneCodeService.addPhoneCode(phoneCode);
    }

    @PutMapping
    @ApiOperation("修改一个电话号码")
    public Response pudataPhoneCode(@RequestBody PhoneCode phoneCode){
        return phoneCodeService.upudataPhoneCode(phoneCode);
    }

    @DeleteMapping
    @ApiOperation("删除全部记录")
    public Response deleteAllPhoneCode(PhoneCode phoneCode){
        return phoneCodeService.deleteAllPhoneCode();
    }

    @DeleteMapping("{id}")
    @ApiOperation("根据id删除一条记录")
    public Response deletePhoneCodeByName(@PathVariable int id){
        return phoneCodeService.deletePhoneCodeById(id);
    }

    @GetMapping
    @ApiOperation("获取全部电话号码")
    public Response getAllPhoneCode(){
        return phoneCodeService.getAllPhoneCode();
    }

    @GetMapping("/{start}/{size}")
    @ApiOperation("分页查询")
    public Response findPhoneCodeByPage(@PathVariable int start,
                                        @PathVariable int size){
        Pager<PhoneCode> page = new Pager<>();
        if(size < 10 || size > 101){
            page.setPageSize(10);
        }else{
            page.setPageSize(size);
        }
        if(start <= 0){
            page.setPageStart(1);
        }else{
            page.setPageStart(start);
        }
        return phoneCodeService.findPhoneCodeByPage(page);
    }

    @GetMapping("/{name}")
    @ApiOperation("按名字查询")
    public Response findPhoneCodeByName(@PathVariable String name){
        return phoneCodeService.findPhoneCodeByName(name);
    }

}
