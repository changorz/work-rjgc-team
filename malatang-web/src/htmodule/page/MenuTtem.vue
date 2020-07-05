<template>
 <div style="padding: 20px">
   <label>菜单项管理</label>
   <router-link to="MenuTtemAdd"><el-button type="primary" style="margin-left: 80%">添加菜单项</el-button></router-link>
   <el-table
     :data="tableData"
     style="width: 90%;margin: 20px auto">>
     <el-table-column
       label="序号"
       min-width="20">
       <template slot-scope="scope">
         <span style="margin-left: 10px">{{scope.$index + 1}} </span>
       </template>
     </el-table-column>
     <el-table-column
       label="权重"
       min-width="20">
       <template slot-scope="scope">
         <span style="margin-left: 10px">{{ scope.row.weight }}</span>
       </template>
     </el-table-column>
     <el-table-column
       label="分类"
       min-width="20">
       <template slot-scope="scope">
         <span style="margin-left: 10px">{{ scope.row.title }}</span>
       </template>
     </el-table-column>
     <el-table-column
       label="图标路径"
       min-width="50">
       <template slot-scope="scope">
         <el-popover trigger="hover" placement="top">
           <div class="demo-image__placeholder">
             <div class="block">
               <el-image
                 style="width: 150px; height: 150px"
                 :src="scope.row.icon"
                 fit="contain"
               >
                 <div slot="placeholder" class="image-slot">
                   加载中<span class="dot">...</span>
                 </div>
               </el-image>
             </div>
           </div>
           <div slot="reference" class="name-wrapper">
             <el-tag size="medium">{{ scope.row.icon }}</el-tag>
           </div>
         </el-popover>
       </template>
     </el-table-column>
     <el-table-column
       label="名称"
       min-width="30">
       <template slot-scope="scope">
         <span style="margin-left: 10px">{{ scope.row.text }}</span>
       </template>
     </el-table-column>
     <el-table-column
       label="转跳地址"
       min-width="40">
       <template slot-scope="scope">
         <span style="margin-left: 10px">{{ scope.row.tourl }}</span>
       </template>
     </el-table-column>
     <el-table-column label="操作">
       <template slot-scope="scope">
         <el-button
           size="mini"
           @click="handleEdit(scope.row)">编辑</el-button>
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
import * as ht from '../api/ht'
import notify from '../methdos/inform'

export default {
  name: 'MenuTtem',
  data () {
    return {
      tableData: []
    }
  },
  methods: {
    handleEdit (value) {
      this.$router.push({
        name: '更新菜单项管理',
        params: value
      })
      // this.$router.push('menuTtemUptate')
    },
    handleDelete (id) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const _id = id
        ht.deleteMenuItem(id).then((res) => {
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
    }
  },
  beforeCreate () {
    ht.getAllMenuItem().then((res) => {
      this.tableData = res.queryResult.list
    }).catch(() => {
      notify.error(this, '加载数据')
    })
  }
}
</script>

<style scoped>

</style>
