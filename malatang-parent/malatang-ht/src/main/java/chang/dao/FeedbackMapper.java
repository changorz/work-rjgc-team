package chang.dao;

import chang.pojo.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FeedbackMapper {

    void addFeedback(Feedback feedback);

    /**
     * 通过openid查询反馈次数
     * @return
     */
    int findCountFeedbackByOpenid(String openid);

    // 后台修改Feedback的状态
    void updataFeedback(@Param("id") int id, @Param("dispose") int dispose);

    // 后台分页查询
    //TODO 这里的泛型可以修改成Vo，用联合查询添加姓名等字段
    List<Feedback> findFeedbackPage(@Param("start") int start, @Param("size")int size);

    int findFeedbackPageCount();

    /**
     * 后台分页查询by状态
     * @param dispose 是否处理，-1忽略，0待处理，1已处理
     * @param start
     * @param size
     * @return
     */
    List<Feedback> findFeedbackPageByDispose(@Param("dispose") int dispose, @Param("start") int start, @Param("size")int size);

    int findFeedbackPageByDisposeCount(int dispose);
}
