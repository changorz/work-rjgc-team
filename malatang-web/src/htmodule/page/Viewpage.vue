<template>
  <div style="padding: 20px">
    <label>轮播图管理</label>
    <div style="width: 100%; margin: 20px 5%;">
      <div  style="display: inline-block;">
        <el-upload
          class="upload-demo"
          :show-file-list="false"
          drag
          action
          accept="image/gif, image/jpeg"
          :http-request="handleUpload"
        >
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">只能上传jpg/png文件</div>
        </el-upload>
      </div>
      <div style="display: inline-block; width:50%;float: right; margin: 0 10% 0 5%">
        <label>图床添加：</label>
        <el-form label-width="100px" class="demo-ruleForm">
          <el-form-item label="图片路径">
            <el-input v-model="ruleFormUrl"></el-input>
          </el-form-item>
        </el-form>
        <el-button
          type="primary"
          class="but"
          size="mini"
          @click="butonclic(ruleFormUrl)">添加图片</el-button>
      </div>
    </div>
    <el-table
      :data="tableData"
      style="width: 90%;margin: 20px auto">
      <el-table-column
        label="图片地址"
        min-width="600">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <div class="demo-image__placeholder">
              <div class="block">
                <el-image
                  style="width: 200px; height: 150px"
                  :src="scope.row.url"
                  fit="contain"
                >
                  <div slot="placeholder" class="image-slot">
                    加载中<span class="dot">...</span>
                  </div>
                </el-image>
              </div>
            </div>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.url }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import * as alioos from '../../api/ali-oss'
import * as ht from '../api/ht'
import notify from '../methdos/inform'

export default {
  data () {
    return {
      tableData: [],
      ruleFormUrl: ''
    }
  },
  methods: {
    handleDelete (id) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const _id = id
        ht.deleteViewpage(id).then((res) => {
          if (res.code === 10000) {
            notify.success(this, '删除数据')
            for (let i = 0; i < this.tableData.length; i++) {
              if (this.tableData[i].id === _id) {
                this.tableData.splice(i, 1)
              }
            }
          } else {
            notify.error(this, '删除数据')
          }
        }).catch(() => {
          notify.error(this, '删除数据')
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    butonclic (value) {
      if (value) {
        var reg = new RegExp('/(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?/')
        if (reg.test(value)) {
          this.add(value)
          this.ruleFormUrl = ''
        } else {
          this.$message({
            showClose: true,
            message: '请输入正确的图片地址',
            type: 'error'
          })
        }
      } else {
        this.$message({
          showClose: true,
          message: '路径不能为空！',
          type: 'warning'
        })
      }
    },
    uuid () {
      var s = []
      var hexDigits = '0123456789abcdef'
      for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1)
      }
      s[14] = '4'
      s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1)
      s[8] = s[13] = s[18] = s[23] = '-'

      var uuid = s.join('')
      return uuid
    },
    handleUpload (option) {
      // 生成的文件名称
      const objName = this.uuid()
      // 调用 ali-oss 中的方法
      alioos.put(`lbt/${objName}.jpg`, option.file).then(res => {
        this.add(res.url)
      })
    },
    // 向后台添加图片
    add (url) {
      const params = {
        id: 0,
        url: url
      }
      ht.addViewpage(params).then((res) => {
        if (res.success === true) {
          notify.success(this, '添加图片')
          this.tableData.splice(length, 0, res.result)
        } else {
          notify.error(this, res.message + ' 添加图片')
        }
      }).catch(() => {
        notify.error(this, '添加图片')
      })
    }
  },
  beforeCreate () {
    ht.getAllViewpage().then((res) => {
      this.tableData = res.queryResult.list
      // notify.success(this, '加载数据')
    }).catch(() => {
      notify.error(this, '加载数据')
    })
  }
}
</script>

<style scoped>
.el-form{
  margin: 10px 0 5px 0;
}
.but{
  float: right;
}
</style>
