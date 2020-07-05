package chang.controller;

import chang.model.response.Response;
import chang.model.response.plus.QueryResponseResult;
import chang.pojo.Viewpager;
import chang.service.ViewpagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "轮播图控制controller",description="增删查轮播图")
@RestController
// 管理员 md:微信端 菜单
@RequestMapping("/admin/md/viewpage")
public class ViewPagerController {

    @Autowired
    ViewpagerService viewpagerService;

    @PostMapping
    @ApiOperation("添加一个图片")
    public Response viewpagerAdd(@RequestBody Viewpager viewpager){
        return viewpagerService.addViewpager(viewpager);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除一个图片")
    public Response viewpagerDelete(@PathVariable("id") int id){
        return viewpagerService.deleteViewpager(id);
    }

    @GetMapping
    @ApiOperation("查询全部图片")
    public QueryResponseResult viewpagerGet(){
        return viewpagerService.findAllViewpager();
    }

}
