<template>
    <div style="padding: 20px">
      <!--表格上面的div-->
      <div>
        <div id="top">
          <div id="title-top">
            当前总记录 <el-tag  type="success">{{title.count}}</el-tag><br>
            更新时间 <el-tag  type="success">{{title.time}}</el-tag><br>
          </div>
          <el-upload
            class="upload"
            action="http://abc.com:9002/admin/md/repair"
            :on-success="fileOnSuccess"
            :on-error="fileOnError"
            multiple
            :show-file-list="false"
            :limit="3"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip" style="color: rgba(232,9,9,0.92)">只能上传Excel文件，excel上传会清空原有数据！</div>
          </el-upload>
        </div>
        <div id="input-div">
          <!-- 搜索框，可以输入  可以搜索： 姓名or学号(1)，班级(级联选择器)and课程(模糊搜索)-->
          <div style="display: inline-block">
            <el-form :inline="true">
              <el-form-item>
                <el-input placeholder="输入学号或者姓名查询" v-model="xhORname"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="but1">查询</el-button>
              </el-form-item>
            </el-form>
          </div>

          <div style="display: inline-block;float: right;margin-right: 61.8px">
            <el-form  :inline="true">
              <el-form-item style="width: 300px">
                <el-autocomplete
                  v-model="bjmc"
                  :fetch-suggestions="querySearchAsyncBj"
                  placeholder="请输入班级"
                  style="width: 300px"
                ></el-autocomplete>
              </el-form-item>
              <el-form-item style="width: 300px">
                <el-autocomplete
                  v-model="kcmc"
                  :fetch-suggestions="querySearchAsyncKc"
                  placeholder="请输入课程名称"
                  style="width: 300px"
                ></el-autocomplete>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="but2">搜索</el-button>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
      <!--表格div-->
      <div>
        <el-table
          :data="tableData"
          style="width: 100%">
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="left" inline class="demo-table-expand">
                <el-form-item label="姓名">
                  <span>{{ props.row.name }}</span>
                </el-form-item>
                <el-form-item label="学号">
                  <span>{{ props.row.xh }}</span>
                </el-form-item>
                <el-form-item label="学年学期">
                  <span>{{ props.row.xqid }}</span>
                </el-form-item>
                <el-form-item label="课程名称">
                  <span>{{ props.row.kcmc }}</span>
                </el-form-item>
                <el-form-item label="课程属性">
                  <span>{{ props.row.kcsx }}</span>
                </el-form-item>
                <el-form-item label="课程性质">
                  <span>{{ props.row.kcxz }}</span>
                </el-form-item>
                <el-form-item label="总成绩">
                  <span>{{ props.row.zcj }}</span>
                </el-form-item>
                <el-form-item label="学分">
                  <span>{{ props.row.xf }}</span>
                </el-form-item>
                <el-form-item label="上课院系">
                  <span>{{ props.row.skyx }}</span>
                </el-form-item>
                <el-form-item label="上课年级">
                  <span>{{ props.row.sknj }}</span>
                </el-form-item>
                <el-form-item label="上课专业">
                  <span>{{ props.row.skzy }}</span>
                </el-form-item>
                <el-form-item label="上课班级">
                  <span>{{ props.row.skbj }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column
            label="学号"
            prop="xh">
          </el-table-column>
          <el-table-column
            label="姓名"
            prop="name">
          </el-table-column>
          <el-table-column
            label="班级"
            prop="skbj">
          </el-table-column>
          <el-table-column
            label="挂科课程"
            prop="kcmc">
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
  data () {
    return {
      title: {
        count: 0,
        time: ''
      },
      tableData: [],
      xhORname: '',
      bjmc: '',
      kcmc: '',
      page: {
        intdex: 1,
        page_size: 10,
        total: 600
      }
    }
  },
  methods: {
    fileOnSuccess (response, file, fileList) {
      this.$message({
        message: '文件上传成功',
        type: 'success'
      })
      setTimeout(() => {
        this.$router.go(0)
      }, 1000)
    },
    // eslint-disable-next-line handle-callback-err
    fileOnError (err, file, fileList) {
      this.$message.error('文件上传失败')
    },
    // 学号or姓名搜索按钮
    but1 () {
      // 清空其他条件
      this.bjmc = ''
      this.kcmc = ''
      if (this.xhORname === '') {
        this.updataList(this.page.intdex, this.page.page_size, this.bjmc, this.kcmc)
      }
      ht.findPageByName(this.xhORname).then((res) => {
        if (res.success) {
          this.tableData = res.queryResult.list
          this.page.total = 0
        } else {
          this.$message.error('查询数据失败')
        }
      })
    },
    // 班级and课程名称搜索按钮
    but2 () {
      // 清空其他条件
      this.xhORname = ''
      this.updataList(this.page.intdex, this.page.page_size, this.bjmc, this.kcmc)
    },
    // 每页条数发生变化
    handleSizeChange (val) {
      this.page.page_size = val
      this.updataList(this.page.intdex, this.page.page_size, this.bjmc, this.kcmc)
    },
    // 页数发生变化
    handleCurrentChange (val) {
      this.updataList(this.page.intdex, this.page.page_size, this.bjmc, this.kcmc)
    },
    updataList (start, size, a, b) {
      ht.findPage(start, size, a, b).then((res) => {
        if (res.success) {
          this.tableData = res.result.rows
          this.page.intdex = res.result.pageStart
          this.page.page_size = res.result.pageSize
          this.page.total = res.result.total
        } else {
          this.$message.error('获取数据失败')
        }
      })
    },
    querySearchAsyncBj (queryString, cb) {
      var restaurants = this.restaurants_bj
      var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants
      clearTimeout(this.timeout)
      this.timeout = setTimeout(() => {
        cb(results)
      }, 500 * Math.random())
    },
    querySearchAsyncKc (queryString, cb) {
      var restaurants = this.restaurants_kc
      var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants
      clearTimeout(this.timeout)
      this.timeout = setTimeout(() => {
        cb(results)
      }, 500 * Math.random())
    },
    createStateFilter (queryString) {
      return (state) => {
        return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) !== -1)
      }
    }
  },
  beforeCreate () {
    ht.findPage(1, 10, '', '').then((res) => {
      if (res.success) {
        this.title.count = res.result.total
        this.title.time = res.result.rows[0].endTime
        this.tableData = res.result.rows
        this.page.intdex = res.result.pageStart
        this.page.page_size = res.result.pageSize
        this.page.total = res.result.total
      } else {
        this.$message.error('获取数据失败')
      }
    })
  },
  mounted () {
    ht.getAllBj().then((res) => {
      this.restaurants_bj = res.queryResult.list
    })
    ht.getAllKc().then((res) => {
      this.restaurants_kc = res.queryResult.list
    })
  }
}
</script>
<style>
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
</style>
<style scoped>
  #top{
    background-color: rgba(68, 56, 57, 0.38);
    height: 66px;
    border-radius: 6px;
    padding: 6.18px;
  }
  #title-top{
    display: inline-block;
    font-size: 17px;
    font-family: 宋体;
  }
  .el-tag{
    height: 28px;
    margin: 3px auto;
  }
  #input-div{
    padding: 20px 0 0 5px;
  }
  .upload{
    margin: auto 200px;
    display: inline-block;
  }
  .el-pagination{
    margin: 30px 35%;
  }
  /*复制*/
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
