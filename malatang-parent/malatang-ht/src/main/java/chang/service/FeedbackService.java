package chang.service;

import chang.model.response.Response;
import chang.pojo.Feedback;
import chang.pojo.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackService {

    Response addFeedback(Feedback feedback);

    Response findCountFeedbackByOpenid(String openid);

    // 更新状态
    Response updataFeedback(@Param("id") int id, @Param("dispose") int dispose);

    // 后台分页查询
    Response findFeedbackPage(Pager pager);

    /**
     * 后台分页查询by状态
     * @return
     */
    Response findFeedbackPageByDispose(@Param("dispose") int dispose, Pager pager);

}
