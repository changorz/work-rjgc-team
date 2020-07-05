package chang.service.Impl;

import chang.dao.ViewpagerMapper;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResponseResult;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.model.response.plus.QueryResponseResult;
import chang.model.response.plus.QueryResult;
import chang.pojo.Viewpager;
import chang.service.ViewpagerService;
import chang.utils.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ViewpagerServiceImpl implements ViewpagerService {

    @Autowired
    ViewpagerMapper viewpagerMapper;
    @Autowired
    OSSUtil ossUtil;

    public QueryResponseResult findAllViewpager() {
        List<Viewpager> allViewpager = viewpagerMapper.findAllViewpager();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(allViewpager);
        queryResult.setTotal(allViewpager.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    public Response addViewpager(Viewpager viewpager) {
        if(StringUtils.isEmpty(viewpager.getUrl()) || viewpager.getUrl().indexOf("http") != 0){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        try {
            viewpagerMapper.addViewpager(viewpager);
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        ObjectResult objectResult = new ObjectResult(CommonCode.SUCCESS, viewpager);
        return objectResult;
    }

    public Response deleteViewpager(int id) {
        Viewpager viewpager = viewpagerMapper.findViewpagerById(id);
        if(!"".equals(viewpager.getUrl())&&viewpager.getUrl().indexOf("chang1024.oss-cn-beijing.aliyuncs.com/lbt/") != -1){
            ossUtil.deleteFile("lbt" + viewpager.getUrl().substring(viewpager.getUrl().lastIndexOf('/')));
        }
        try {
            viewpagerMapper.deleteViewpager(id);
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        return ResponseResult.SUCCESS();
    }
}
