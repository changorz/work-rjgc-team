package chang.service.Impl;

import chang.Vo.Autocomplete;
import chang.dao.RepairMapper;
import chang.dao.es.ESRepair;
import chang.listener.UploadRepairEasyExcelListener;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.ResponseResult;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.model.response.plus.QueryResponseResult;
import chang.model.response.plus.QueryResult;
import chang.pojo.Pager;
import chang.pojo.Repair;
import chang.service.RepairService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements RepairService{

    @Autowired
    RepairMapper repairMapper;

    @Override
    public Response uploadExcel(InputStream fileStream) {
        try{
            // 1.清空以前的数据库
            repairMapper.deleteRepairAll();
            EasyExcel.read(fileStream, Repair.class, new UploadRepairEasyExcelListener(repairMapper)).sheet(0).doRead();
        }catch (Exception e){
            ExceptionCast.cast(CommonCode.FILE_READ_ERR);
        }
        return new ResponseResult(CommonCode.FILE_READ_OK);
    }

    @Override
    public Response findPage(Pager page) {
        int size = page.getPageSize();
        int start = (page.getPageStart() - 1) * size;
        List<Repair> repairList = repairMapper.findPage(start, size);
        page.setRows(repairList);
        int count = repairMapper.getRepairCount();
        page.setTotal(count);
        return new ObjectResult(CommonCode.SUCCESS,page);
    }


    @Override
    public Response getAllBj() {
        List<Repair> allBj = repairMapper.getAllBj();
        ArrayList array = new ArrayList<Autocomplete>();
        allBj.forEach((e) -> {
            array.add(new Autocomplete(e.getSkbj()));
        });
        QueryResult queryResult = new QueryResult();
        queryResult.setList(array);
        queryResult.setTotal(array.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public Response getAllKc() {
        List<Repair> allKc = repairMapper.getAllKc();
        ArrayList array = new ArrayList<Autocomplete>();
        allKc.forEach((e) -> {
            array.add(new Autocomplete(e.getKcmc()));
        });
        QueryResult queryResult = new QueryResult();
        queryResult.setList(array);
        queryResult.setTotal(array.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public Response findPageByMap(Pager page, Map map) {
        int size = page.getPageSize();
        int start = (page.getPageStart() - 1) * size;
        List<Repair> repairList = repairMapper.findPageByMap(map, start, size);
        page.setRows(repairList);
        int count = repairMapper.findPageByMapCount(map);
        page.setTotal(count);
        return new ObjectResult(CommonCode.SUCCESS,page);
    }

    @Override
    public Response findPageByName(String xh, String name) {
        List<Repair> repairList = repairMapper.findByXhOrName(xh, name);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(repairList);
        queryResult.setTotal(repairList.size());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
