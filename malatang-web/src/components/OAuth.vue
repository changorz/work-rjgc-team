<template>
    <div style="background-color:#fff;">
      <img
        src="https://img.zcool.cn/community/0147d85b320ba0a80120b959abcc40.gif"
         width="100%"
        height="100%"
        style="margin: 100px 0"
      >
    </div>
</template>

<script>
import * as ht from '../api/ht'
export default {
  name: 'OAuth',
  methods: {
  },
  beforeCreate () {
    const code = this.$route.query.code
    if (code === undefined ||
      code === null || code > 20) {
      setTimeout(() => {
        // code 为空，重定向
        ht.getWxLoginUrl().then(res => {
          window.location.href = res
        })
      }, 1000)
    } else {
      // 使用code登录
      ht.getUser(code).then(res => {
        if (res.success) {
          this.$store.commit('setWx', res.result)
          // 存入sessionStorage
          sessionStorage.setItem('wx', JSON.stringify(res.result))
          this.$router.push('/')
        } else {
          this.$router.push('/OAuth')
        }
      })
    }
  }
}
</script>
<style scoped>
</style>
