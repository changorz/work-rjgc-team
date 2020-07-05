<template>
  <div style="margin: 20px">
    <div>
      <div style="display: inline-block; font-size: 20px;margin-top: 15px;margin-left: 10px">
        查看反馈记录
      </div>
      <div style="float: right; margin: 5px 20px 15px 0">
        <el-button type="primary" plain @click="but1">全部</el-button>
        <el-button type="success" plain @click="but2">已阅</el-button>
        <el-button type="info" plain @click="but3">忽略</el-button>
        <el-button type="warning" plain @click="but4">待处理</el-button>
      </div>
    </div>
    <div>
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          label="openid"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.openid }}</span>
          </template>
        </el-table-column>
        <!-- -->
        <el-table-column
          label="内容">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.context }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="时间">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{scope.row.time[0] + '-' + scope.row.time[1] + '-' + scope.row.time[2]  + '  ' + scope.row.time[3] + ':' + scope.row.time[4] + ':' + scope.row.time[5]}}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="状态">
          <template slot-scope="scope">
            <el-button style="margin-left: 10px" :type="ztType[(scope.row.dispose + 1) % 3]" plain disabled>{{ zt[(scope.row.dispose + 1) % 3] }}</el-button>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="success"
              @click="handle1(scope.$index, scope.row)" icon="el-icon-check" circle></el-button>
            已阅
            <el-button
              size="mini"
              type="danger"
              @click="handle2(scope.$index, scope.row)" circle>一</el-button>
            忽略
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 分页div -->
    <div>
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page.sync=page.intdex
        layout="sizes, prev, pager, next"
        :page-sizes="[10, 20, 50, 100]"
        :page-size=page.page_size
        :total=page.total
        hide-on-single-page
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import * as ht from '../../api/ht'
export default {
  name: 'Index',
  data () {
    return {
      tableData: [],
      page: {
        intdex: 1,
        page_size: 10,
        total: 600
      },
      flag: 2,
      zt: ['忽略', '待处理', '已阅'],
      ztType: ['info', 'warning', 'success']
    }
  },
  methods: {
    but1 () {
      this.flag = 2
      this.updataList()
    },
    but2 () {
      this.flag = 1
      this.updataList()
    },
    but3 () {
      this.flag = -1
      this.updataList()
    },
    but4 () {
      this.flag = 0
      this.updataList()
    },
    handle1 (index, row) {
      ht.updataFeedback(row.id, 1).then(res => {
        if (res.success) {
          this.updataList()
        } else {
          this.$message.error('更新状态失败')
        }
      })
    },
    handle2 (index, row) {
      ht.updataFeedback(row.id, -1).then(res => {
        if (res.success) {
          this.updataList()
        } else {
          this.$message.error('更新状态失败')
        }
      })
    },
    // 每页条数发生变化
    handleSizeChange (val) {
      this.page.page_size = val
      console.log(val)
      // this.updataList(this.page.intdex, this.page.page_size, this.bjmc, this.kcmc)
    },
    // 页数发生变化
    handleCurrentChange (val) {
      console.log(val)
      // this.updataList(this.page.intdex, this.page.page_size, this.bjmc, this.kcmc)
    },
    updataList () {
      if (this.flag === 2) {
        ht.findFeedbackPage(this.page.intdex, this.page.page_size).then(res => {
          if (res.success) {
            this.tableData = res.result.rows
            this.page.intdex = res.result.pageStart
            this.page.page_size = res.result.pageSize
            this.page.total = res.result.total
          } else {
            this.$message.error('获取数据失败')
          }
        })
      } else {
        ht.findFeedbackPageByDispose(this.page.intdex, this.page.page_size, this.flag).then(res => {
          if (res.success) {
            this.tableData = res.result.rows
            this.page.intdex = res.result.pageStart
            this.page.page_size = res.result.pageSize
            this.page.total = res.result.total
          } else {
            this.$message.error('获取数据失败')
          }
        })
      }
    }
  },
  created () {
    this.updataList()
  }
}
</script>

<style scoped>
  .el-pagination{
    margin: 30px 30%;
  }
</style>
