package chang.dao;

import chang.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GradeMapper {

    void addGrade(Grade grade);

    Grade findGradeByOpenid(String openid);

    double getAvg();

}
