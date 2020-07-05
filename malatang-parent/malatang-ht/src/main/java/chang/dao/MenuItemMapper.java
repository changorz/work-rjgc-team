package chang.dao;

import chang.pojo.MenuItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MenuItemMapper {

    MenuItem findMenuItemById(int id);

    List<MenuItem> findAllMenuItem();

    int addMenuItem(MenuItem menuItem);

    int deleteMenuItem(int id);

    int updataMenuItem(Map map);

    /**
     * 安装title分组查询
     * @return
     */
    List<MenuItem> findAllGuoup();

    List<MenuItem> findMenuItemByTitle(String title);

}
