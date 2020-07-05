<template>
<!--  这是一个学号绑定的模块-->
  <div>
    <div id="div1">
      <div id="lab">教务绑定</div>
      <el-image
        src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589725418154&di=c88f09be3844ff25bafae2b5826ef144&imgtype=0&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D178636512%2C2624051830%26fm%3D214%26gp%3D0.jpg"
        style="width: 5rem; height: 5rem"
      />
    </div>
    <div id="div2">
      <label>请输入教务系统信息</label>
      <CellGroup>
        <Field
          value=""
          required
          label="学号"
          placeholder="请输入学号"
          v-model="xh"
        />

        <Field
          value=""
          type="password"
          label="密码"
          placeholder="请输入密码"
          required
          v-model="pwd"
        />
      </CellGroup>
      <div id="but">
        <Button type="primary" block hairline @click="onBind">绑定</Button>
      </div>
    </div>
  </div>
</template>

<script>
import { CellGroup, Field, Button, Toast } from 'vant'
import * as qz from './../api/qz'
export default {
  name: 'xhBind',
  components: {
    CellGroup,
    Field,
    Button,
    // eslint-disable-next-line vue/no-unused-components
    Toast
  },
  data () {
    return {
      xh: '',
      pwd: ''
    }
  },
  methods: {
    onBind () {
      if (this.xh === '') {
        Toast('学号不能为空')
        return
      }
      if (this.pwd === '') {
        Toast('密码不能为空')
        return
      }
      if (isNaN(this.xh) || this.xh < 20160000 || this.xh > 20509999) {
        Toast('学号：格式错误')
        return
      }
      if (String(this.pwd).length < 6 || String(this.pwd).length > 20) {
        Toast('密码：格式错误')
        return
      }
      Toast.loading({
        duration: 0,
        mask: true,
        forbidClick: true, // 禁用背景点击
        message: '绑定中...'
      })
      /*
        1. 异步请求强智
        2. 成功后保存到vuex和cookie
        3. 用户信息发送到后端记录
        4. 路由跳转
     */
      const para = {
        xh: this.xh,
        pwd: this.pwd,
        method: 'authUser'
      }
      qz.getQzInfo(para).then((res) => {
        if (res.success) {
          // 2. 成功后保存到vuex和cookie
          this.$store.commit('setQz', res)
          this.$cookies.set('qz', res)
          // 用户信息发送到后端记录
          // 待完成
          // 路由跳转
          const url = this.$cookies.get('re_url')
          this.$cookies.remove('re_url')
          console.log(location.host)
          if (url == null) {
            window.location.href = '/'
          } else {
            window.location.href = url
          }
        } else {
          // 提示错误
          Toast.clear()
          Toast.fail('账号或密码错误！')
          this.pwd = ''
        }
      })
    }
  }
}
</script>

<style scoped>
  #but{
    margin: 1rem 1rem;
  }
  label{
    padding: .5rem;
    margin-bottom: 1rem;
  }
  #div2{
    margin: 1.18em 2rem;
  }
  #div1{
    text-align: center;
    padding: 3rem;
  }
  #lab{
    font-size: 3rem;
    color: #3cc51f;
  }

</style>
