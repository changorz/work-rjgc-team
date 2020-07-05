<template>
  <div>
    <div>
      <div style="display: inline-block; float: left">
        <img :src=$store.state.wx.headImgUrl
             id="headImg" />
      </div>
      <div style="display: inline-block; height: 6.5rem;float: left">
        <div id="name">{{$store.state.qz.userrealname?$store.state.qz.userrealname:'学号未绑定'}}</div>
        <div id="bj">{{$store.state.qz.user.useraccount?"学号：" + $store.state.qz.user.useraccount:''}}</div>
      </div>
      <div style="display: inline-block; float: left"
           class="from"
           v-show="isShow">
        <input type="text"
               placeholder="请输入学号">
        <input type="text"
               placeholder="请输入密码">
        <input type="text"
               placeholder="请输入手机号">
      </div>
      <div style="display: inline-block; height: 6.5rem;float: right">
        <i id="inkimg"
           class="el-icon-link"
           @click='show'></i>
      </div>
      <hr>
    </div>
    <confirm ref="myConfirm"></confirm>
  </div>
</template>

<script>
import confirm from '../Confirm.vue'
export default {
  name: 'right',
  components: {
    confirm
  },
  data () {
    return {
      isShow: false,
      popup: 0
    }
  },
  methods: {
    show () {
      if (this.$store.state.qz.userrealname) {
        this.$refs.myConfirm.show('是否要解除绑定')
      } else {
        this.isShow = true
      }
    }
  }
}
</script>

<style scoped>
#headImg {
  width: 5rem;
  border-radius: 2.5rem;
  margin: 1rem 1rem 0.5rem 1rem;
}
hr {
  width: 95%;
  background-color: #37ff00;
}
#name {
  margin: 1.7rem 0 0rem 0.5rem;
  height: 2em;
  font-size: 1.3em;
}
#bj {
  color: #a7a7a7;
  font-size: 1em;
  margin: 0rem 0 0rem 0.5rem;
}
#inkimg {
  font-size: 2em;
  margin: 1.2em 1em;
  color: #1fafe8;
}
  .from{
  padding:1rem;
    width: 60%;
  }
  .from input{
    margin:0.4rem 0 ;

    border-radius: 0.2rem;
  }

</style>
