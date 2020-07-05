<template>
  <div>
    <router-view ref="table"/>
    <nav>
      <div @click="befor"><a><img src="../../../assets/kdqn/static/picture/d679e9a73af1fd00174783718a88dca1.png"><br>上周课表</a></div>
      <div @click="befor_after"><a style="color: #1baf1d"><img src="../../../assets/kdqn/static/picture/CgpQVFmVoo6AQlGfAAAycC0uhxk09302.jpg"><br>{{kbtext}}</a></div>
<!--      <div @click="updata"><a><img src="../../../assets/kdqn/static/picture/CgpQU1l8Ex-AY-8_AAAqrtd-KS884382.jpg"><br>更新</a></div>-->
      <div @click="after"><a><img src="../../../assets/kdqn/static/picture/09f24d790ff9c4a988dd1859b9d63735.png"><br>下周课表</a></div>
      <div><a><img src="../../../assets/kdqn/static/picture/3834839e65d9db4b9a8a2103c6655591.png"><br>课表推送</a></div>
<!--      <div><a href="kb_edit.html"><img src="../../../assets/kdqn/static/picture/cf2c-1ecb-4bac-be3b-d5d9685b0c19.jpg"><br>自定义</a></div>-->
    </nav>
  </div>
</template>

<script>
export default {
  name: 'Tabber',
  data () {
    return {
      flag: true, // 全周
      kbtext: '学期课表'
    }
  },
  methods: {
    befor () {
      this.$refs.table.befor()
    },
    after () {
      this.$refs.table.after()
    },
    befor_after () {
      this.flag = !this.flag
      this.kbtext = this.flag ? '学期课表' : '本周课表'
      this.$refs.table.befor_after(this.flag)
    }
  }
}
</script>

<style scoped src="../../../assets/kdqn/static/css/timetable_bg.css">

</style>
