# 03-init

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

-------------------------------------------
# 项目进度

## 微信登录模块

**开发思路**

1. 前端调用/user/oauth接口，后端传回微信授权地址
2. 前端跳转授权地址，并获取回调地址后带的code
3. 使用code，请求/user/publicInfo接口，获取用户信息





## 强智登录模块

1. 从cookie中获取，没有就不做操作，有就存入store
2. 进入需要强智token的页面才去检测token，先简单检测（姓名，学号那些可以复用，没必要请求后台），然后获取数据的时候检测
3. 如果不满足条件或者token过期，调用store中的异步方法updataQzInfo刷新数据
4. 如果学号或者密码错误，则重定向到学号绑定页面

![](https://pic.gksec.com/2020/03/30/fbd15eac15dcb/20200330144546.png)

![](https://pic.gksec.com/2020/03/30/7e3dd9d987ca7/20200330144633.png)

**关键代码**

```js
mutations: {
    setQz (state, qz) {
      state.qz = qz
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
        }
      })
    }
  }
```

## 空教室查询模块
**状态**：已完成









