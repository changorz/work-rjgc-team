<template>
  <div>
    <div v-if="data.queryResult!=null&&data.queryResult.list.length > 0">
      <div id="title">
        你有如下课程挂科
      </div>
      <table v-for="(value, index) in data.queryResult.list" :key="index">
        <tr>
          <td>课程名称</td>
          <td>{{value.kcmc}}</td>
        </tr>
        <tr>
          <td>课程性质</td>
          <td>{{value.kcsx}}-{{value.kcxz}}</td>
        </tr>
        <tr>
          <td>学分</td>
          <td style="color: red">{{value.xf}}</td>
        </tr>
        <tr>
          <td>更新时间</td>
          <td>{{value.endTime.substring(0, 10)}}</td>
        </tr>
      </table>
    </div>
    <div v-else>
      <div id="noLable">恭喜你！没有挂科~~</div>
      <div style="text-align: center">
        <img src="http://img.zcool.cn/community/01dd2d5bdb4015a80121ab5dfbe4a4.gif" width="160">
      </div>
    </div>
  </div>
</template>

<script>
import * as student from '../../../api/studenthtApi'
export default {
  data () {
    return {
      data: ''
    }
  },
  beforeCreate () {
    const xh = this.$store.state.qz.user.useraccount
    // 检测是否存学号
    if (xh === null || xh === '') {
      this.updataQzInfo()
    }
    student.getRepair(xh).then((res) => {
      this.data = res
    })
  }
}
</script>

<style scoped>
  table{
    width: 90%;
    margin: 2rem 8%;
  }
  td:nth-child(n+2){
    color: #a09b9b;
  }
  #noLable{
    color: #3cc51f;
    font-size: 1.5em;
    font-family: 楷体;
    text-align: center;
    margin: 10rem auto 3rem;
  }
  #title{
    color: #3cc51f;
    font-size: 1.5em;
    font-family: 楷体;
    text-align: center;
    margin: 2rem auto 2.5rem;
  }

</style>
