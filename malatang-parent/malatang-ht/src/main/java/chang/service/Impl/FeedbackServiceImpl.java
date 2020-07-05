package chang.service.Impl;

import chang.dao.FeedbackMapper;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResponseResult;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.model.response.plus.QueryResponseResult;
import chang.model.response.plus.QueryResult;
import chang.pojo.Feedback;
import chang.pojo.Pager;
import chang.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackMapper feedbackMapper;

    @Override
    public Response addFeedback(Feedback feedback) {
        if(StringUtils.isEmpty(feedback.getOpenid())
        ||StringUtils.isEmpty(feedback.getContext())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        if(feedbackMapper.findCountFeedbackByOpenid(feedback.getOpenid()) >= 3){
            // 次数大于三
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        feedback.setTime(LocalDateTime.now());
        feedbackMapper.addFeedback(feedback);
        return new ObjectResult(CommonCode.SUCCESS, feedback);
    }

    @Override
    public Response findCountFeedbackByOpenid(String openid) {
        if (StringUtils.isEmpty(openid)){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        int count = feedbackMapper.findCountFeedbackByOpenid(openid);
        return new ObjectResult(CommonCode.SUCCESS, count);
    }

    @Override
    public Response updataFeedback(int id, int dispose) {
        if(dispose>1||dispose<-1){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        feedbackMapper.updataFeedback(id, dispose);
        return ResponseResult.SUCCESS();
    }

    @Override
    public Response findFeedbackPage(Pager pager) {
        int size = pager.getPageSize();
        int start = (pager.getPageStart()-1) * size;
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackPage(start, size);
        pager.setRows(feedbackPage);
        pager.setTotal(feedbackMapper.findFeedbackPageCount());
        return new ObjectResult(CommonCode.SUCCESS, pager);
    }

    @Override
    public Response findFeedbackPageByDispose(int dispose, Pager pager) {
        if(dispose>1||dispose<-1){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        int size = pager.getPageSize();
        int start = (pager.getPageStart()-1) * size;
        List<Feedback> feedbackPage = feedbackMapper.findFeedbackPageByDispose(dispose,start, size);
        pager.setRows(feedbackPage);
        pager.setTotal(feedbackMapper.findFeedbackPageByDisposeCount(dispose));
        return new ObjectResult(CommonCode.SUCCESS, pager);
    }
}
