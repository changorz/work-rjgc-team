<template>
  <div id="app">
    <router-view v-wechat-title='$route.name'/>
  </div>
</template>
<script>
export default {
  methods: {
    // 通过cookie初始化qz基本信息 如果token过期，
    // 使用updataQzInfo更新,
    // 如果没有绑定或者密码错误，跳转到绑定页面
    infoQz () {
      const qz = this.$cookies.get('qz')
      if (qz != null) {
        this.$store.commit('setQz', qz)
      }
    }
  },
  created () {
    this.infoQz()
  }
}
</script>
<style>
  html{
    background-color: rgba(244, 244, 244, 0.65);
  }
  html, body,#app {
    margin: 0;
    height: 100%;
  }
</style>
