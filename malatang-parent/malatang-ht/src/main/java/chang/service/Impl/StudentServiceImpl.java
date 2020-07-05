package chang.service.Impl;

import chang.dao.MenuItemMapper;
import chang.dao.PhoneCodeMapper;
import chang.dao.ViewpagerMapper;
import chang.model.response.CommonCode;
import chang.model.response.Response;
import chang.model.response.myException.ExceptionCast;
import chang.model.response.plus.ObjectResult;
import chang.model.response.plus.QueryResponseResult;
import chang.model.response.plus.QueryResult;
import chang.pojo.MenuItem;
import chang.pojo.PhoneCode;
import chang.pojo.Viewpager;
import chang.service.PhoneCodeService;
import chang.service.StudentService;
import chang.utils.ToPinyinUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    ViewpagerMapper viewpagerMapper;
    @Autowired
    MenuItemMapper menuItemMapper;
    @Autowired
    PhoneCodeMapper phoneCodeMapper;

    public Response getViewPager() {
        List<Viewpager> allViewpager = viewpagerMapper.findAllViewpager();
        ArrayList<String> strings = new ArrayList<String>();
        allViewpager.forEach((e)->{
            strings.add(e.getUrl());
        });
        QueryResult queryResult = new QueryResult();
        queryResult.setList(strings);
        queryResult.setTotal(strings.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    public Response getMenuItem() {
        // List<MenuItem> allGuoup = menuItemMapper.findAllGuoup();
        ArrayList allGuoup = new ArrayList<String>();
        allGuoup.add("教务");
        allGuoup.add("校内");
        allGuoup.add("反馈");


        ArrayList<Map> list = new ArrayList<>();
        allGuoup.forEach(str -> {
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
            // 添加标题
            objectObjectHashMap.put("title",str);
            List<MenuItem> menuItemByTitle = menuItemMapper.findMenuItemByTitle((String) str);
            // 根据权重排序
            menuItemByTitle.sort(Comparator.comparingInt(MenuItem::getWeight));
            ArrayList<Object> date = new ArrayList<>();
            for (MenuItem menuItem1 : menuItemByTitle) {
                HashMap<String, String> map = new HashMap<>();
                map.put("icon",menuItem1.getIcon());
                map.put("text",menuItem1.getText());
                map.put("url",menuItem1.getTourl());
                date.add(map);
            }
            objectObjectHashMap.put("date",date);
            list.add(objectObjectHashMap);
        });
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);
        queryResult.setTotal(list.size());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public Response getAllPhoneCode() {
        List<PhoneCode> allPhoneCode = phoneCodeMapper.getAllPhoneCode();
        HashMap<String, List> map = new HashMap<>();
        for (int i = 65; i <= 90; i++) {
            map.put((char)i + "", new ArrayList<PhoneCode>());
        }
        allPhoneCode.forEach(e->{
            // 1.获取这个e名字的首字母
            String s = "";
            if ("曾".equals(e.getName().charAt(0)+"")){
                s = "Z";
            } else {
                s = ToPinyinUtil.ToFirstChar(e.getName().charAt(0) + "").toUpperCase();
            }
            // 2.获取list，将e加入list
            map.get(s).add(e);
        });
        return new ObjectResult(CommonCode.SUCCESS, map);
    }

    @Override
    public Response findPhoneCodeByName(String name) {
        if(StringUtils.isEmpty(name)){
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        List<PhoneCode> phoneCodeByName = phoneCodeMapper.findPhoneCodeByName("%" + name + "%");
        QueryResult<PhoneCode> objectQueryResult = new QueryResult<>();
        objectQueryResult.setList(phoneCodeByName);
        objectQueryResult.setTotal(phoneCodeByName.size());
        return new QueryResponseResult(CommonCode.SUCCESS, objectQueryResult);
    }
}
