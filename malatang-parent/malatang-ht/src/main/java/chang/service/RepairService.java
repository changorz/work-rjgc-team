package chang.service;

import chang.model.response.Response;
import chang.pojo.Pager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public interface RepairService {

    /**
     * Excel文件上传
     * @return
     * @param inputStream
     */
    Response uploadExcel(InputStream inputStream);

    /**
     * 分页查询全部
     * @param page
     * @return
     */
    Response findPage(Pager page);

    /**
     * 获取所有班级
     * @return
     */
    Response getAllBj();

    /**
     * 获取所有课程
     */
    Response getAllKc();

    Response findPageByMap(Pager page, Map map);

    Response findPageByName(String xh,String name);

}
