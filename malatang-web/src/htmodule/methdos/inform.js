export default {
  success (_this, value) {
    _this.$notify({
      title: '成功',
      message: `${value}成功`,
      type: 'success'
    })
  },
  error (_this, value) {
    _this.$notify({
      title: '错误',
      message: `${value}失败`
    })
  }
}
