package chang.service;

import chang.model.response.Response;
import chang.pojo.Grade;

public interface GradeService {

    Response addGrade(Grade grade);

    Response findGradeByOpenid(String openid);

    Response getAvg();

}
