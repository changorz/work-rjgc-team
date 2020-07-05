import Main from './../page/Main'
import IIMG from '../page/IIMG'
import MenuTtem from './../page/MenuTtem'
import MenuTtemAdd from './../page/MenuTtemAdd'
import MenuItemUpdate from './../page/MenuItemUpdate'
import ViewPage from './../page/Viewpage'
import RepairIndex from './../page/jw/RepairIndex'
import PhoneList from './../page/xn/PhoneList'
import FKIndex from './../page/fk/Index'
import DB from './../page/sys/DB'
import API from './../page/sys/API'

export default [
  {
    path: '/admin',
    component: Main,
    name: '后台管理',
    redirect: '/admin/Iimg',
    children: [
      // md 界面管理
      { path: 'Iimg', component: IIMG, name: '首页图片' },
      { path: 'menuTtem', component: MenuTtem, name: '菜单项管理' },
      { path: 'menuTtemAdd', component: MenuTtemAdd, name: '添加菜单项管理' },
      { path: 'menuTtemUptate', component: MenuItemUpdate, name: '更新菜单项管理' },
      { path: 'viewPage', component: ViewPage, name: '轮播图项管理' },
      // 教务功能模块管理
      { path: 'RepairIndex', component: RepairIndex, name: '重修查询管理' },
      // 校内功能模块管理
      { path: 'PhoneList', component: PhoneList, name: '校园电话簿管理' },
      // 反馈功能模块
      { path: 'FKIndex', component: FKIndex, name: '用户反馈' },
      // 系统模块
      { path: 'DB', component: DB, name: '数据库监控' },
      { path: 'API', component: API, name: '后台接口' }
    ]
  }
]
