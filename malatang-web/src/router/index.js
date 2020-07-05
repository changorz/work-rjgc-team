import store from '@/store'

import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from './../views/index'
import Test from './../views/test'
import OAuth from './../components/OAuth'
import Letf from '../components/menu/left'
import Center from '../components/menu/center'
import Right from '../components/menu/right'
import XhBind from '../views/xhBind'

// 后台路由
import HT from '../htmodule/router'

// 模块路由
import CJ from '../module/cj/router'
// 空教室
import NULLJS from '../module/nulljs/router'
// 课表
import KB from '../module/kb/router'
// 重修
import REPAIR from '../module/repair/router'
// 电话号码
import PHONECODE from '../module/phonecode/router'
// 电话号码
import GPA from '../module/gpa/router'
// 需求
import NEEDHOPE from '../module/needhope/route'
// 反馈
import FK from '../module/fankui/router'
// 后勤
import HQ from '../module/houqin/router'
// 作息时间
import ZXTIME from '../module/zxtime/router'

Vue.use(VueRouter)

let routes = [
  {
    path: '/',
    component: Index,
    redirect: 'center',
    name: '主页',
    children: [
      { path: 'left', component: Letf, name: 'atd' },
      { path: 'center', component: Center, name: '教务' },
      { path: 'right', component: Right, name: 'mi' }
    ]
  },
  { path: '/test', component: Test, name: '测试页面' },
  { path: '/OAuth', component: OAuth, name: '授权' },
  { path: '/xhbind', component: XhBind, name: '学号绑定' }
]

const concat = (router) => {
  routes = routes.concat(router)
}
// 合并路由规则
concat(CJ)
concat(NULLJS)
concat(HT)
concat(KB)
concat(REPAIR)
concat(PHONECODE)
concat(GPA)
concat(NEEDHOPE)
concat(FK)
concat(HQ)
concat(ZXTIME)

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  // 如果是admin页面
  if (to.path.indexOf('/admin') === 0) {
    next()
    return
  }
  // 微信登录信息传入
  const wx = JSON.parse(sessionStorage.getItem('wx'))
  if (wx) {
    store.commit('setWx', wx)
  }
  // 不是授权 并且 用户为空
  if (to.path !== '/OAuth' && store.state.wx.openId === '') {
    next('/OAuth')
  } else {
    next()
  }
})

export default router
