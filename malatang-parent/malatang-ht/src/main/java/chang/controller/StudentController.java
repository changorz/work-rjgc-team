package chang.controller;

import chang.dao.GradeMapper;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.myException.ExceptionCast;
import chang.pojo.Feedback;
import chang.pojo.Grade;
import chang.service.FeedbackService;
import chang.service.GradeService;
import chang.service.RepairService;
import chang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/md/")
@RequiredArgsConstructor
@Api(tags = "Student端获取数据")
public class StudentController {

    private final StudentService studentService;
    private final RepairService repairService;
    private final GradeService gradeService;
    private final FeedbackService feedbackService;


    /**
     * 获取轮播图的图片路径
     * @return
     */
    @GetMapping("getViewPager")
    @ApiOperation("获取轮播图")
    public Response getViewPager(){
        return studentService.getViewPager();
    }

    /**
     * 获取菜单项
     * @return
     */
    @GetMapping("getMenuItem")
    @ApiOperation("获取菜单项")
    public Response getMenuItem(){
        return studentService.getMenuItem();
    }

    @GetMapping("getRepair/{xh}")
    @ApiOperation("获取重修信息")
    public Response getRepair(@PathVariable("xh") String xh){
        return repairService.findPageByName(xh, "");
    }

    @GetMapping("getAllPhoneCode")
    @ApiOperation("获取手机号码列表")
    public Response getAllPhoneCode(){
        return studentService.getAllPhoneCode();
    }

    @GetMapping("getPhoneCode/{name}")
    @ApiOperation("根据名字模糊查询")
    public Response findPhoneCodeByName(@PathVariable String name){
        return studentService.findPhoneCodeByName(name);
    }

    @GetMapping("/grade/{openid}")
    @ApiOperation("查询是否评分过")
    public Response grade(@PathVariable String openid){
        return gradeService.findGradeByOpenid(openid);
    }

    @PostMapping("grade")
    @ApiOperation("用户评分")
    public Response addGrade(@RequestBody Grade grade){
        if(StringUtils.isEmpty(grade.getOpenid())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        if(grade.getNumber()<0){
            grade.setNumber(0);
        }
        if(grade.getNumber()>5){
            grade.setNumber(5);
        }
        return gradeService.addGrade(grade);
    }

    @PostMapping("feedback")
    @ApiOperation("添加反馈信息")
    public Response addFeedback(@RequestBody Feedback feedback){
        return feedbackService.addFeedback(feedback);
    }

    @GetMapping("feedback/{openid}")
    @ApiOperation("查询用户反馈信息次数")
    public Response findCountFeedbackByOpenid(@PathVariable String openid){
        return feedbackService.findCountFeedbackByOpenid(openid);
    }

}
