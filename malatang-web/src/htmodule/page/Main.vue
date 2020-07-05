<template>
  <el-container>
    <el-header>
      <div id="logo">
        <router-link class="el-icon-s-home" to="/admin">Malater后台管理</router-link>
      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-row>
          <el-col :span="24">
            <el-menu
              default-active="2"
              class="el-menu-vertical-demo"
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b"
              router>
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-s-opportunity" style="color: rgba(232,232,39,0.82)"></i>
                  <span>界面管理</span>
                </template>
                  <el-menu-item index="viewPage">轮播图管理</el-menu-item>
                  <el-menu-item index="menuTtem">菜单项管理</el-menu-item>
              </el-submenu>
<!-- ======================================================================================================= -->
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-location" style="color: rgba(0,253,200,0.82)"></i>
                  <span>教务管理</span>
                </template>
                <el-menu-item index="RepairIndex">重修管理</el-menu-item>
              </el-submenu>
<!-- ======================================================================================================= -->
              <el-submenu index="3">
                <template slot="title">
                  <i class="el-icon-s-check" style="color: rgba(25,0,255,0.82)"></i>
                  <span>校内管理</span>
                </template>
                <el-menu-item index="PhoneList">校园电话簿</el-menu-item>
              </el-submenu>
<!-- ======================================================================================================= -->
              <el-submenu index="4">
                <template slot="title">
                  <i class="el-icon-finished" style="color: rgba(255,2,2,0.82)"></i>
                  <span>反馈管理</span>
                </template>
                <el-menu-item index="FKIndex">用户反馈信息</el-menu-item>
              </el-submenu>
<!-- ======================================================================================================= -->
              <el-submenu index="5">
                <template slot="title">
                  <i class="el-icon-rank" style="color: rgba(44,255,0,0.86)"></i>
                  <span>系统管理</span>
                </template>
                <el-menu-item index="API">API管理</el-menu-item>
                <el-menu-item index="DB">数据库监控</el-menu-item>
              </el-submenu>
<!-- ======================================================================================================= -->
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'Main',
  methods: {
  }
}
</script>

<style scoped>
  .el-container {
    height: 100%;
    padding: 0;
    margin: 0;
    width: 100%;
  }
  .el-header {
    background-color: rgba(55, 68, 101, 0.76);
    color: #FFF;
  }
  .el-aside {
    background-color: #545c64;
    color: #333;
  }
  .el-main {
    background-color: rgba(233, 238, 243, 0.73);
    color: #333333;
    padding: 0;
  }
  #logo > a {
    font-size: 22px;
    color: #00fab6;
    margin: 20px 10px;
  }
</style>
