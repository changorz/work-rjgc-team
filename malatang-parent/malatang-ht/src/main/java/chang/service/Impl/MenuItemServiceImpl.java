package chang.service.Impl;

import chang.dao.MenuItemMapper;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResponseResult;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.myException.MyException;
import chang.model.response.plus.QueryResponseResult;
import chang.model.response.plus.QueryResult;
import chang.pojo.MenuItem;
import chang.service.MenuItemService;
import chang.utils.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    MenuItemMapper menuItemMapper;
    @Autowired
    OSSUtil ossUtil;

    public QueryResponseResult findAllMenuItem() {
        List<MenuItem> allMenuItem = menuItemMapper.findAllMenuItem();
        allMenuItem.sort(Comparator.comparing(MenuItem::getTitle).reversed());
        QueryResult<MenuItem> objectQueryResult = new QueryResult<MenuItem>();
        objectQueryResult.setList(allMenuItem);
        objectQueryResult.setTotal(allMenuItem.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
        return queryResponseResult;
    }

    public Response addMenuItem(MenuItem menuItem) {
        if(StringUtils.isEmpty(menuItem.getTitle())||
                StringUtils.isEmpty(menuItem. getIcon())||
                StringUtils.isEmpty(menuItem.getText())||
                StringUtils.isEmpty(menuItem.getTourl())||
                StringUtils.isEmpty(menuItem.getWeight())||
                !menuItem.getIcon().startsWith("http")
        ){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        try {
            menuItemMapper.addMenuItem(menuItem);
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return ResponseResult.SUCCESS();
    }

    public Response deleteMenuItem(int id) {
        MenuItem menuItem = menuItemMapper.findMenuItemById(id);
        if(!"".equals(menuItem.getIcon())&&menuItem.getIcon().indexOf("chang1024.oss-cn-beijing.aliyuncs.com/lbt/") != -1){
            ossUtil.deleteFile("lbt" + menuItem.getIcon().substring(menuItem.getIcon().lastIndexOf('/')));
        }
        try {
            menuItemMapper.deleteMenuItem(id);
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return ResponseResult.SUCCESS();
    }

    public Response updataMenuItem(Map map) {
        int id = Integer.parseInt(map.get("id").toString());
        MenuItem menuItem = menuItemMapper.findMenuItemById(id);
        // 如果不相同就删除
        if(!menuItem.equals(map.get("icon"))){
            // 如果匹配到是自己的oss，就行删除操作
            if(!"".equals(menuItem.getIcon())&&menuItem.getIcon().indexOf("chang1024.oss-cn-beijing.aliyuncs.com/lbt/") != -1){
                ossUtil.deleteFile("lbt" + menuItem.getIcon().substring(menuItem.getIcon().lastIndexOf('/')));
            }
        }
        try {
            menuItemMapper.updataMenuItem(map);
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return ResponseResult.SUCCESS();
    }
}
