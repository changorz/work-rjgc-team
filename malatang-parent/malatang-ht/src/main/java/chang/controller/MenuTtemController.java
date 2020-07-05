package chang.controller;

import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.myException.ExceptionCast;
import chang.pojo.MenuItem;
import chang.service.MenuItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "移动端菜单控制controller",description="md表示微信端，增删改查微信端的菜单项")
@RestController
// 管理员 md:微信端 菜单
@RequestMapping("/admin/md/menu")
public class MenuTtemController {

    @Autowired
    MenuItemService menuItemService;

    @PostMapping()
    @ApiOperation("添加一个菜单项")
    public Response menuAdd(@RequestBody MenuItem menuTetm){
        return menuItemService.addMenuItem(menuTetm);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除一个菜单项")
    public Response menuDelete(@PathVariable("id") int id){
        return menuItemService.deleteMenuItem(id);
    }

    @PutMapping
    @ApiOperation("更新一个菜单项")
    public Response menuPut(@RequestBody MenuItem menuTetm ){
        Map map = new HashMap();
        map.put("id",menuTetm.getId());
        if(menuTetm.getWeight() != 0){ map.put("weight",menuTetm.getWeight()+"");}
        if(menuTetm.getTitle() != null && !"".equals(menuTetm.getTitle())){ map.put("title",menuTetm.getTitle());}
        if(menuTetm.getIcon() != null && !"".equals(menuTetm.getIcon())){ map.put("icon",menuTetm.getIcon());}
        if(menuTetm.getText() != null && !"".equals(menuTetm.getText())){ map.put("text",menuTetm.getText());}
        if(menuTetm.getTourl() != null && !"".equals(menuTetm.getTourl())){ map.put("tourl",menuTetm.getTourl());}
        return menuItemService.updataMenuItem(map);
    }

    @GetMapping
    @ApiOperation("查询全部菜单项")
    public Response menuGet(){
        return menuItemService.findAllMenuItem();
    }

}
