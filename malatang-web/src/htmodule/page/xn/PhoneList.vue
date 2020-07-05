<template>
    <div style="margin: 20px">
      <div><el-link type="primary" @click="$router.go(0)" class="el-icon-s-home">联系方式管理</el-link></div>
      <div style="margin: 15px">
        <div style="display: inline-block">
          <el-upload
            class="upload-demo"
            action="http://abc.com:9002/admin/md/phoneCode"
            :show-file-list="false"
            :on-success="fileAC"
            style="display: inline-block;margin-right: 15px"
          >
            <el-button type="primary">Ecxel上传<i class="el-icon-upload el-icon--right"></i></el-button>
          </el-upload>
          <el-button type="success" @click="addCall">手动添加</el-button>
          <el-button type="danger" @click="deleteAllPhoneCode">删除全部</el-button>
        </div>
        <div style="float: right; margin-right: 40px;display: inline-block">
          <el-input
            v-model="input"
            placeholder="姓名搜索"
            prefix-icon="el-icon-search"
            style="width: 200px;margin-right: 15px"
          ></el-input>
          <el-button type="primary" @click="findCall">搜索</el-button>
        </div>
      </div>
      <div>
        <el-table
          :data="tableData"
          style="width: 100%;margin-top: 30px">
          <el-table-column
            label="姓名"
            width="180">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.name }}</span>
            </template>
          </el-table-column>
          <el-table-column
            label="联系方式"
            width="380">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.number }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 弹出框 -->
        <el-dialog title="修改" :visible.sync="dialogFormVisible">
          <el-form :model="form">
            <el-form-item label="姓名" :label-width="formLabelWidth">
              <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="联系方式" :label-width="formLabelWidth">
              <el-input v-model="form.number" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="updataCall">确 定</el-button>
          </div>
        </el-dialog>
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
      tableData: [],
      input: '',
      page: {
        intdex: 1,
        page_size: 10,
        total: 600
      },
      dialogTableVisible: false,
      dialogFormVisible: false,
      formLabelWidth: '120px',
      form: {
        id: '',
        name: '',
        number: ''
      }
    }
  },
  methods: {
    fileAC () {
      this.$message({
        message: '文件上传成功',
        type: 'success'
      })
      setTimeout(() => {
        this.$router.go(0)
      }, 1000)
    },
    addCall () {
      this.form.id = ''
      this.form.name = ''
      this.form.number = ''
      this.dialogFormVisible = true
    },
    findCall () {
      if (this.input === '') {
        this.updataPhoneCode(this.page.intdex, this.page.page_size)
      } else {
        ht.findPhoneCodeByName(this.input).then(res => {
          if (res.success) {
            this.tableData = res.queryResult.list
            this.page.total = 0
            if (this.tableData.length === 0) {
              this.$message('没有查到信息')
            } else {
              this.$message.success('查询成功')
            }
          } else {
            this.$message.error('查询数据失败')
          }
        })
      }
    },
    updataCall () {
      this.dialogFormVisible = false
      if (this.form.id === '') {
        // 添加操作
        ht.addPhoneCode(this.form).then(res => {
          if (res.success) {
            this.$message.success('添加成功')
            this.updataPhoneCode(this.page.intdex, this.page.page_size)
          } else {
            this.$message.error('添加失败')
          }
        })
      } else {
        // 更新操作
        ht.updataPhoneCode(this.form).then(res => {
          if (res.success) {
            this.$message.success('修改成功')
            this.updataPhoneCode(this.page.intdex, this.page.page_size)
          } else {
            this.$message.error('修改失败')
          }
        })
      }
    },
    handleEdit (index, row) {
      this.form.id = row.id
      this.form.name = row.name
      this.form.number = row.number
      this.dialogFormVisible = true
    },
    handleDelete (index, row) {
      ht.deletePhoneCode(row.id).then(res => {
        if (res.success) {
          this.$message.success('删除成功')
          this.updataPhoneCode(this.page.intdex, this.page.page_size)
        } else {
          this.$message.error('删除数据失败')
        }
      })
      console.log(row.id)
    },
    deleteAllPhoneCode () {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        ht.deleteAllPhoneCode().then(res => {
          if (res.success) {
            this.updataPhoneCode(this.page.intdex, this.page.page_size)
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
          } else {
            this.$message({
              type: 'error',
              message: '删除失败!'
            })
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleSizeChange (val) {
      this.page.page_size = val
      this.updataPhoneCode(this.page.intdex, this.page.page_size)
    },
    handleCurrentChange (val) {
      this.page.intdex = val
      this.updataPhoneCode(this.page.intdex, this.page.page_size)
    },
    updataPhoneCode (start, size) {
      ht.findPhoneCodePage(start, size).then(res => {
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
  },
  created () {
    this.updataPhoneCode(this.page.intdex, this.page.page_size)
  }
}
</script>

<style scoped>
  .el-pagination{
    margin: 30px 32%;
  }
</style>
