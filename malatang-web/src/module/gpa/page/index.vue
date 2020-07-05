<template>
    <div>
      <div id="title">
        <div id="title1">平均绩点计算器</div>
        <div id="title2">{{xq==='全部学期'?'本学期':'全部学期'}}</div>
      </div>
      <br>
      <div>
        <label v-if="xqflag">{{xqids[xqindex % 8].xqmc}}</label>
        <label style="margin-left: 0.8rem;color: #0d0d0d">平均GPA：<span style="color: #ffad00">{{gpadata.avg}}</span></label>
        <label style="margin-left: 0.8rem;color: #0d0d0d">选定学分：<span style="color: #ffad00">{{gpadata.count}}</span></label>
        <div>
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%;margin-top: .6rem"
            @selection-change="handleSelectionChange">
            <el-table-column
              type="selection"
              width="45">
            </el-table-column>
            <el-table-column
              label="课程"
              width="130">
              <template slot-scope="scope">{{ scope.row.kcmc }}</template>
            </el-table-column>
            <el-table-column
              prop="xf"
              label="学分"
              width="60">
            </el-table-column>
            <el-table-column
              prop="zcj"
              label="分数"
              width="60">
            </el-table-column>
            <el-table-column
              label="绩点"
              width="60"
              show-overflow-tooltip>
              <template slot-scope="scope">
                {{isNaN(scope.row.zcj)?scope.row.zcj:((parseInt(scope.row.zcj)-60)>=0 ?( (scope.row.zcj-60)/10+1).toFixed(1):0)}}
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>
      <div id="butdiv">
        <el-button type="success" @click="xqBefter" :disabled="disabled1">上学期</el-button>
        <el-button type="primary" @click="xqChange">{{xq}}</el-button>
        <el-button type="success" @click="xqAfter" :disabled="disabled2">下学期</el-button>
      </div>
    </div>
</template>

<script>
import * as qz from '../../../api/qz'
import { mapActions } from 'vuex'

export default {
  data () {
    return {
      tableData: [],
      multipleSelection: [],
      xq: '全部学期',
      xqflag: true,
      // 学期id数组，最多8个,0位置是当前学期
      xqids: [{ xqmc: '' }],
      // 对应的数组index
      xqindex: 8,
      disabled1: false,
      disabled2: true,
      gpadata: {
        avg: '0',
        count: '0'
      }
    }
  },
  methods: {
    ...mapActions(['updataQzInfo']),
    handleSelectionChange (val) {
      let count = 0.0
      let xfs = 0.0
      for (let i = 0; i < val.length; i++) {
        let zcj = val[i].zcj
        const xf = val[i].xf
        if (zcj === '不及格') {
          zcj = 0
        }
        if (zcj === '及格') {
          zcj = 60
        }
        if (zcj === '中等' || zcj === '中') {
          zcj = 70
        }
        if (zcj === '良好' || zcj === '良') {
          zcj = 80
        }
        if (zcj === '优秀' || zcj === '优') {
          zcj = 90
        }
        zcj = Number.parseInt(zcj)
        // 绩点
        const jd = zcj < 60 ? 0 : 1 + (zcj - 60) / 10.0
        // ∑(课程学分×成绩绩点)
        count += xf * jd
        // ∑课程学分
        xfs += xf
      }
      this.gpadata.count = Number.parseInt(xfs)
      this.gpadata.avg = (count / xfs).toFixed(2)
      // 根据改变，修改平均绩点
    },
    xqBefter () {
      this.xqindex = this.xqindex + 1
      if (this.xqindex % 8 === 7) {
        // 到达第一个，禁用上学期，否则启用下学期
        this.disabled1 = true
      } else {
        this.disabled1 = false
        this.disabled2 = false
      }
      this.updataCj(this.xqids[this.xqindex % 8].xqmc)
    },
    xqChange () {
      this.xqflag = !this.xqflag
      if (this.xqflag) {
        this.xq = '全部学期'
        this.updataCj(this.xqids[this.xqindex % 8].xqmc)
      } else {
        this.xq = '本 学 期'
        this.tableData = []
        for (let i = 0; i < this.xqids.length; i++) {
          const params = {
            method: 'getCjcx',
            xh: this.$store.state.qz.user.useraccount,
            xnxqid: this.xqids[i].xqmc
          }
          qz.getQz(params, this.$store.state.qz.token).then(res => {
            if (res.token != null && res.token === '-1') {
              console.log('token过期，updataqzinfo更新了数据')
              this.updataQzInfo()
              return
            }
            // if (res.result.length === 0) {
            //   this.tableData = [{
            //     kcmc: '空',
            //     zcj: '0',
            //     xf: '0'
            //   }]
            // } else {
            //   this.tableData = res.result
            // }
            // 表格全选
            this.tableData = this.tableData.concat(res.result)
            this.$nextTick(() => {
              for (let i = 0; i < this.tableData.length; i++) {
                this.$refs.multipleTable.toggleRowSelection(
                  this.tableData[i],
                  true
                )
              }
            })
          })
        }
      }
    },
    xqAfter () {
      this.xqindex = this.xqindex - 1
      if (this.xqindex % 8 === 0) {
        // 到达第一个，禁用下学期，否则启用下学期
        this.disabled2 = true
      } else {
        this.disabled1 = false
        this.disabled2 = false
      }
      this.updataCj(this.xqids[this.xqindex % 8].xqmc)
    },
    getXqid () {
      const params = {
        method: 'getXnxq',
        xh: this.$store.state.qz.user.useraccount
      }
      const _this = this
      qz.getQz(params, _this.$store.state.qz.token).then(res => {
        if (res.token != null && res.token === '-1') {
          console.log('token过期，updataqzinfo更新了数据')
          this.updataQzInfo()
          return
        }
        for (let i = 0; i < 8; i++) {
          this.$set(this.xqids, i, res[i])
          if (i === 0) {
            this.updataCj(res[0].xqmc)
          }
        }
      })
    },
    updataCj (xqid) {
      const params = {
        method: 'getCjcx',
        xh: this.$store.state.qz.user.useraccount,
        xnxqid: xqid
      }
      qz.getQz(params, this.$store.state.qz.token).then(res => {
        if (res.result.length === 0) {
          this.tableData = [{
            kcmc: '空',
            zcj: '0',
            xf: '0'
          }]
        } else {
          this.tableData = res.result
        }
        // 表格全选
        this.$nextTick(() => {
          for (let i = 0; i < this.tableData.length; i++) {
            this.$refs.multipleTable.toggleRowSelection(
              this.tableData[i],
              true
            )
          }
        })
      })
    },
    toggleSelection (rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    }
  },
  created () {
    this.getXqid()
  }
}
</script>
<style scoped>
  #title{
    text-align: center;
  }
  #title1{
    color: #3cc51f;
    font-size: 1.8rem;
    margin: 1rem auto .5rem;
  }
  #title2{
    color: #ccc;
  }
  label{
    margin-left: 0.5rem;
    margin-bottom: 1.2rem;
    color: #ccc;
  }
  #butdiv{
    text-align: center;
    margin-top: 1.6rem;
  }
</style>
