package chang.controller;

import chang.model.response.Response;
import chang.pojo.Pager;
import chang.pojo.PhoneCode;
import chang.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/feefbock")
@RequiredArgsConstructor
@Api(tags = "反馈后台接口类")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @ApiOperation("更新反馈的状态")
    @PutMapping("/{id}/{dispose}")
    public Response updataFeedback(@PathVariable int id,@PathVariable int dispose){
        return feedbackService.updataFeedback(id, dispose);
    }

    @ApiOperation("反馈-分页查询")
    @GetMapping("/{pageStart}/{size}")
    public Response findFeedbackPage(@PathVariable int pageStart,
                                     @PathVariable int size){
        Pager<PhoneCode> page = new Pager<>();
        if(size < 10 || size > 101){
            page.setPageSize(10);
        }else{
            page.setPageSize(size);
        }
        if(pageStart <= 0){
            page.setPageStart(1);
        }else{
            page.setPageStart(pageStart);
        }
        return feedbackService.findFeedbackPage(page);
    }

    @ApiOperation("反馈-分页查询by状态")
    @GetMapping("/{pageStart}/{size}/{dispose}")
    public Response findFeedbackPageByDispose(@PathVariable int pageStart,
                                     @PathVariable int size,
                                     @PathVariable int dispose){
        Pager<PhoneCode> page = new Pager<>();
        if(size < 10 || size > 101){
            page.setPageSize(10);
        }else{
            page.setPageSize(size);
        }
        if(pageStart <= 0){
            page.setPageStart(1);
        }else{
            page.setPageStart(pageStart);
        }
        return feedbackService.findFeedbackPageByDispose(dispose,page);
    }

}
