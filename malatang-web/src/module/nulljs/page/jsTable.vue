<template>
    <div>
      <CHeader/>
      <div></div>
      <div>
        <table>
          <tr>
            <th>校区</th>
            <th>教学楼</th>
            <th>教室名称</th>
            <th>座位数量</th>
          </tr>
          <tr v-for="(value, index) in mydata" :key="index">
            <td>{{value.xqmc}}</td>
            <td>{{value.jzwmc}}</td>
            <td>{{value.jsmc}}</td>
            <td>{{value.zws}}</td>
          </tr>
        </table>
      </div>
    </div>
</template>

<script>
import * as qz from '../../../api/qz'
import { mapActions } from 'vuex'
import CHeader from './c_header'
import { Toast } from 'vant'
export default {
  name: 'jsTable',
  components: {
    CHeader,
    // eslint-disable-next-line vue/no-unused-components
    Toast
  },
  data () {
    return {
      ctime: '',
      mydata: []
    }
  },
  methods: {
    ...mapActions(['updataQzInfo'])
  },
  created () {
    Toast.loading({
      message: '加载中...',
      forbidClick: true,
      duration: 'toast'
    })
    // 获取当天时间
    const a = ['日', '一', '二', '三', '四', '五', '六']
    const day1 = new Date(this.$route.params.time)
    day1.setTime(day1.getTime())
    var s1 = '您查询的是 ' + day1.getFullYear() + '年' + (day1.getMonth() + 1) + '月' + day1.getDate() + '日 ' + '星期' + a[day1.getDay()]
    this.ctime = s1
    // --------------------------分割线------------------------------------
    const token = this.$store.state.qz.token
    if (token == null || token === '-1' || String(token).length !== 128) {
      console.log('updataqzinfo更新了数据')
      this.updataQzInfo()
    }
    const paeams = this.$route.params
    qz.getQz(paeams, token).then(res => {
      if (res.token != null && res.token === '-1') {
        console.log('token过期，updataqzinfo更新了数据')
        this.updataQzInfo()
        return
      }
      for (let i = 0; i < res.data[0].jsList.length; i++) {
        this.$set(this.mydata, i, res.data[0].jsList[i])
      }
    })
    Toast('查询成功')
  }
}
</script>

<style scoped>
  table{
    width: 100%;
    text-align: center;
    border-collapse:collapse;
    font-size: .75rem;
    margin: 1rem 0;
  }
  td, th{
    height: 2rem;
    border: rgba(203, 203, 203, 0.15) solid 1px;
    width: 25%
  }
  tr:nth-child(even) {
    background: #fffbff;
  }
  tr:nth-child(odd) {
    background: rgba(203, 203, 203, 0.15);
  }

</style>
