package chang.service;

import chang.model.response.Response;
import chang.model.response.plus.QueryResponseResult;
import chang.pojo.MenuItem;

import java.util.Map;

public interface MenuItemService {

    QueryResponseResult findAllMenuItem();

    Response addMenuItem(MenuItem menuItem);

    Response deleteMenuItem(int id);

    Response updataMenuItem(Map map);

}
