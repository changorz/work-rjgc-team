<template>
  <div style="width: 100%">
    <div style="margin: 1em">我们的产品是否满足您的需求？ 请写下您的建议：</div>
    <div style="margin-left: 1em; color: rgba(246,234,0,0.85);padding: 0.4em">
      Ps:每个用户仅能反馈3次，您剩余
      <span style="color: red">{{count}}</span>
      次。
    </div>
    <textarea style="background:#ccFFCC;border-radius: .5em; padding: .8em;box-sizing:border-box;" v-model="text" maxlength="1000" :disabled="count<=0"></textarea>
    <van-button type="info" @click="but" :disabled="count<=0">提  交</van-button>
  </div>
</template>

<script>
import * as studentApi from '../../../api/studenthtApi'
import Vue from 'vue'
import { Button, Notify } from 'vant'
Vue.use(Button)
Vue.use(Notify)
export default {
  data () {
    return {
      text: '',
      count: 0
    }
  },
  methods: {
    but () {
      if (this.text.length < 10) {
        Notify({ type: 'danger', message: '长度不得小于10' })
      } else {
        const params = {
          openid: this.$store.state.wx.openId,
          context: this.text
        }
        studentApi.addFeedback(params).then(res => {
          if (res.success) {
            Notify({ type: 'success', message: '提交成功' })
            this.count--
            this.text = ''
          } else {
            Notify({ type: 'danger', message: '提交失败' })
          }
        })
      }
    }
  },
  beforeCreate () {
    studentApi.findFeedbackCount(this.$store.state.wx.openId).then(res => {
      if (res.success) {
        this.count = 3 - res.result
      } else {
        Notify({ type: 'danger', message: '服务器繁忙' })
      }
    })
  }
}
</script>

<style scoped>
  textarea{
    width: 94%;
    height: 10em;
    margin: 0 3% 1em;
  }
  .van-button{
    margin-left: 70%;
    width: 6.5em;
    border-radius: .618em;
  }
</style>
