import Vue from 'vue'
import Vuex from 'vuex'
import * as qz from '../api/qz'
import VueCookies from 'vue-cookies'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    qz: {
      success: true,
      token: '',
      user: {
        scsj: null,
        username: '',
        sjyzm: null,
        userdwmc: '',
        usertype: '',
        userpasswd: '',
        useraccount: ''
      },
      // 女1男2
      usertype: '',
      userrealname: '',
      userdwmc: ''
    },
    wx: {
      openId: '',
      nickname: '',
      sex: '',
      province: '',
      city: '',
      country: '',
      headImgUrl: '',
      privilege: [],
      unionid: ''
    }
  },
  mutations: {
    setQz (state, qz) {
      state.qz = qz
    },
    setWx (state, wx) {
      state.wx = wx
    }
  },
  actions: {
    // 通过cookie的数据 异步刷新用户的强智基本信息
    updataQzInfo (context) {
      // 通过保存的cook来给params赋值
      const params = {
        xh: this.state.qz.user.useraccount,
        pwd: this.state.qz.user.userpasswd,
        method: 'authUser'
      }
      qz.getQzInfo(params).then(res => {
        if (res.token === '-1') {
          console.log('密码错误或学号错误:' + res.token)
          // this.$router.push('/xhbind') 报错当前的url
          VueCookies.set('re_url', window.location.href)
          window.location.href = '/xhbind'
        } else {
          context.commit('setQz', res)
          VueCookies.set('qz', res)
          // eslint-disable-next-line no-self-assign
          window.location.href = location.href
        }
      })
    }
  },
  modules: {
  }
})
