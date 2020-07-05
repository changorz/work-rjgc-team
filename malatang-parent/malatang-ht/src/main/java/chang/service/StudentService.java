package chang.service;

import chang.model.response.Response;

public interface StudentService {

    /**
     * 获取轮播图
     * @return
     */
    public Response getViewPager();

    /**
     * 获取菜单项
     * @return
     */
    public Response getMenuItem();

    /**
     * 获取全部手机号码
     * @return
     */
    public Response getAllPhoneCode();

    /**
     * 获取全部手机号码
     * @return
     */
    public Response findPhoneCodeByName(String name);

}
