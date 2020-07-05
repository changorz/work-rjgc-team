import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'vant/lib/index.less'
import { Lazyload } from 'vant'
import VueWechatTitle from 'vue-wechat-title'
import './assets/font/iconfont.css'
import store from './store'
import VueCookies from 'vue-cookies'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false
// 图片懒加载
Vue.use(Lazyload, {
  preLoad: 1.3,
  error: 'https://pic.gksec.com/2020/03/30/4025c1bea1b80/20200330221441.png',
  loading: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2701646041,3975227449&fm=26&gp=0.jpg',
  attempt: 3
})
// 动态修改标题插件
Vue.use(VueWechatTitle)
VueCookies.config('180d')
Vue.use(VueCookies)
Vue.use(ElementUI)
new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
