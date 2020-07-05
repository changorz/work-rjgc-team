package chang.service;

import chang.model.response.Response;
import chang.model.response.plus.QueryResponseResult;
import chang.pojo.Viewpager;

import java.util.List;

public interface ViewpagerService {

    QueryResponseResult findAllViewpager();

    Response addViewpager(Viewpager viewpager);

    Response deleteViewpager(int id);

}
