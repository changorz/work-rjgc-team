package chang.controller;

import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.myException.ExceptionCast;
import chang.pojo.Pager;
import chang.pojo.Repair;
import chang.service.RepairService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Api(tags = "重修控制类")
@RequestMapping("/admin/md/repair")
@RestController
public class RepairController {

    @Autowired
    RepairService repairService;

    @ApiOperation("Excel文件上传")
    @PostMapping
    public Response uploadExcel(MultipartFile file)  {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            return repairService.uploadExcel(inputStream);
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

    /**
     *
     * @param start 页数
     * @param size 页大小
     * @param skbj 班级
     * @param kcmc 课程名称
     * @return
     */
    @ApiOperation("分页查询,可以输入班级或者课程名称进行模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="start",value="页数",required=true,paramType="path"),
            @ApiImplicitParam(name="size",value="页大小",required=true,paramType="path"),
            @ApiImplicitParam(name="bj",value="班级",required=true,paramType="path"),
            @ApiImplicitParam(name="kcmc",value="课程名称",required=true,paramType="path")
    })
    @GetMapping("/{start}/{size}/a{skbj}/b{kcmc}")
    public Response findPage(
            @PathVariable int start,
            @PathVariable int size,
            @PathVariable String  skbj,
            @PathVariable String  kcmc
    ){
        Pager<Repair> page = new Pager<>();
        if(size < 10 || size > 200){
            page.setPageSize(10);
        }else{
            page.setPageSize(size);
        }
        if(start <= 0){
            page.setPageStart(1);
        }else{
            page.setPageStart(start);
        }

        if(StringUtils.isEmpty(skbj)&&StringUtils.isEmpty(kcmc)){
            // 无条件查询
            return repairService.findPage(page);
        } else {
            HashMap<Object, Object> map = new HashMap<>();
            if(!StringUtils.isEmpty(skbj)){
                map.put("skbj", '%' + skbj + '%');
            }
            if(!StringUtils.isEmpty(kcmc)){
                map.put("kcmc", '%' + kcmc + '%');
            }
            // 通过课程and班级查询
            return repairService.findPageByMap(page, map);
        }
    }

    @ApiOperation("按姓名或者学号查询")
    @GetMapping("{name}")
    public Response findPageByName(@PathVariable("name") String nameOrXh){
        if(org.apache.commons.lang3.StringUtils.isNumeric(nameOrXh)){
            return repairService.findPageByName(nameOrXh, "");
        }else{
            return repairService.findPageByName("", nameOrXh);
        }
    }

    /**
     * 获取全部班级
     * @return
     */
    @ApiOperation("获取全部班级")
    @GetMapping("getAllBj")
    public Response getAllBj() {
        return repairService.getAllBj();
    }

    /**
     * 获取全部课程
     * @return
     */
    @ApiOperation("获取全部课程")
    @GetMapping("getAllKc")
    public Response getAllKc(){
        return repairService.getAllKc();
    }

}
