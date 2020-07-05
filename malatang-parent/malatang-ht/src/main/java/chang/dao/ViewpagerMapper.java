package chang.dao;

import chang.pojo.Viewpager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ViewpagerMapper {

    Viewpager findViewpagerById(int id);

    List<Viewpager> findAllViewpager();

    int addViewpager(Viewpager viewpager);

    int deleteViewpager(int id);

}
