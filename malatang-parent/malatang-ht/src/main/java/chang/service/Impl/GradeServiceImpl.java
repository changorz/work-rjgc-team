package chang.service.Impl;

import chang.dao.GradeMapper;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResponseResult;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.pojo.Grade;
import chang.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Response addGrade(Grade grade) {
        gradeMapper.addGrade(grade);
        return ResponseResult.SUCCESS();
    }

    @Override
    public Response findGradeByOpenid(String openid) {
        Grade gradeByOpenid = gradeMapper.findGradeByOpenid(openid);
        return new ObjectResult(CommonCode.SUCCESS, gradeByOpenid);
    }

    @Override
    public Response getAvg() {
        double avg = gradeMapper.getAvg();
        return new ObjectResult(CommonCode.SUCCESS, avg);
    }
}
