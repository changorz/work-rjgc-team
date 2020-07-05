<template>
  <div  style="padding: 20px">
    <label>修改菜单项</label>
    <div id="div1">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="权重" prop="weight">
          <el-input v-model="ruleForm.weight"></el-input>
        </el-form-item>
        <el-form-item label="类别" prop="title">
          <el-select v-model="ruleForm.title" placeholder="请选择活动区域">
            <el-option label="教务" value="教务"></el-option>
            <el-option label="校内" value="校内"></el-option>
            <el-option label="反馈" value="反馈"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="图标地址" prop="icon">
          <el-input v-model="ruleForm.icon" style="width: 80%; float: left; margin-right: 10px"></el-input>
          <el-upload
            class="upload-demo"
            :http-request="imgUpload"
            :show-file-list="false"
            accept="image/gif, image/jpeg"
            action>
            <el-button size="small" type="primary">本地上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="名称" prop="text">
          <el-input v-model="ruleForm.text"></el-input>
        </el-form-item>
        <el-form-item label="转跳地址" prop="tourl">
          <el-input v-model="ruleForm.tourl"></el-input>
        </el-form-item>
        <div class="div-but">
          <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import * as ht from '../api/ht'
import notify from '../methdos/inform'
import * as alioos from '../../api/ali-oss'

export default {
  name: 'MenuItemUpdate',
  data () {
    return {
      ruleForm: {
        weight: '',
        title: '教务',
        icon: '',
        text: '',
        tourl: ''
      },
      rules: {
        weight: [
          { required: true, message: '请输入权重', trigger: 'blur' },
          { validator: this.myweight }
        ],
        title: [
          { required: true, message: '请选择类别', trigger: 'blur' }
        ],
        icon: [
          { required: true, message: '请输入图标地址', trigger: 'blur' }
        ],
        text: [
          { required: true, message: '请输入名称', trigger: 'blur' }
        ],
        tourl: [
          { required: true, message: '请输入转跳地址', trigger: 'blur' }
        ]
      }
    }
  },
  created () {
    this.ruleForm = this.$router.history.current.params
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          ht.updateMenuItem(this.ruleForm).then((res) => {
            if (res.code === 10000) {
              notify.success(this, '修改数据')
              this.$router.push('menuTtem')
            } else {
              notify.error(this, '修改数据')
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    // 自定义表单验证
    myweight (rule, value, callback) {
      if (!Number.parseInt(value) && Number.parseInt(value) !== 0) {
        callback(new Error('请输入大于0的数字，等于0前端不展示'))
      } else if (Number.parseInt(value) < 0) {
        callback(new Error('权重需大于等于0，等于0前端不展示'))
      } else {
        callback()
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
    // 文件上传
    imgUpload (option) {
      // 生成的文件名称
      const objName = this.uuid()
      // 调用 ali-oss 中的方法
      alioos.put(`lbt/${objName}.jpg`, option.file).then(res => {
        this.ruleForm.icon = res.url
      })
    }
  }
}
</script>

<style scoped>
  #div1{
    margin: 20px 15%;
    padding: 20px 0;
    width: 70%;
  }
  .el-form{
    margin: 20px 5% 20px 0;
  }
  .div-but{
    float: right;
  }

</style>
