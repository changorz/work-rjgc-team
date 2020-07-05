<template>
  <div>
    <label id="lab1">涉外学院-空教室查询</label>
    <br>
    <label id="lab2">{{this.$parent.ctime}}</label>
  </div>
</template>

<script>
export default {
  name: 'c_header'
}
</script>

<style scoped>
  div{
    text-align: center;
    padding: 1.2rem 0 .5rem 0;
  }
  #lab1{
    font-size: 1.2rem;
    color: rgba(39, 197, 26, 0.89);
  }
  #lab2{
    color: #8e8e8e;
    font-size: .9rem;
  }
</style>
