<template>
    <div>
      <div style="font-size: 1.5em; margin: 2rem">给我们评个分吧<span v-if="flag" style="color: red">(已评分)</span></div>
      <div align="center" style="margin-top: 3rem">
        <van-rate
          v-model="value"
          :size="30"
          color="#ee0a24"
          void-icon="star"
          void-color="#eee"
          :readonly = flag
        />
      </div>
      <div>
        <van-button type="info" @click="but" v-if="!flag">评分</van-button>
      </div>
    </div>
</template>

<script>
import * as studentApi from '../../../api/studenthtApi'
import Vue from 'vue'
import { Notify, Rate } from 'vant'
Vue.use(Rate)
export default {
  name: 'grade',
  data () {
    return {
      value: 0,
      // 是否评分过
      flag: true
    }
  },
  methods: {
    but () {
      const params = {
        number: this.value,
        openid: this.$store.state.wx.openId
      }
      studentApi.addGrade(params).then(res => {
        if (res.success) {
          Notify({ type: 'success', message: '评分成功' })
          this.flag = !this.flag
        } else {
          Notify({ type: 'danger', message: '评分失败' })
        }
      })
    }
  },
  beforeCreate () {
    studentApi.findIsGrade(this.$store.state.wx.openId).then(res => {
      if (res.success && res.result === null) {
        this.flag = false
      } else {
        this.value = res.result.number
        this.flag = true
      }
    })
  }
}
</script>

<style scoped>
  .van-button{
    font-size: .8em;
    margin-top: 1.5em;
    margin-left: 70%;
    border-radius: .5em;
  }

</style>
