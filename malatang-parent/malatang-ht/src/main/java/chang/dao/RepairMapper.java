package chang.dao;

import chang.Vo.Autocomplete;
import chang.model.response.Response;
import chang.pojo.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RepairMapper {

    /**
     * 插入一条数据
     * @param repair 重修实体类
     * @return
     */
    int addRepair(Repair repair);

    /**
     * 插入一组组数据
     * @param repairs
     * @return
     */
    void addRepairList(List<Repair> repairs);

    /**
     * 根据id删除一条数据
     * @param id
     * @return
     */
    int deleteRepair(int id);

    /**
     * 删除所有数据
     * @return
     */
    int deleteRepairAll();

    /**
     * 分页查询，待修改，采用分页参数
     * @param pageStart 开始记录，不包括 pageStart = 页数 * 页面大小   从0页开始
     * @param pageSize  页面大小
     * @return
     */
    List<Repair> findPage(@Param("pageStart")int pageStart, @Param("pageSize")int pageSize);

    /**
     * 通过学号，姓名或者查询
     */
    List<Repair> findByXhOrName(@Param("xh") String xh,@Param("name") String name);

    /**
     * 课程名称 or 班级    模糊 + 分页
     */
    List<Repair> findPageByMap(@Param("map")Map map,@Param("pageStart")int pageStart, @Param("pageSize")int pageSize);
    int findPageByMapCount(@Param("map")Map map);

    /**
     * 获取总记录数
     * @return
     */
    int getRepairCount();

    /**
     * 获取所有班级
     * @return
     */
    List<Repair> getAllBj();

    /**
     * 获取所有课程
     */
    List<Repair> getAllKc();


}
