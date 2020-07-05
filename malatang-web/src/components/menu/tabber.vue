<template>
    <div>
      <router-view/>
      <Tabbar
        v-model="active"
        active-color="#07c160"
        inactive-color="#000"
      >
        <TabbarItem icon="home-o" to="left">team</TabbarItem>
        <TabbarItem icon="search" to="center">教务</TabbarItem>
        <TabbarItem icon="friends-o" to="right">mi</TabbarItem>
      </Tabbar>
      <!-- 底部 footer -->
      <Foo/>
    </div>
</template>

<script>
import { Tabbar, TabbarItem } from 'vant'
import Foo from '../foo'
export default {
  name: 'tabber',
  components: {
    Tabbar,
    TabbarItem,
    Foo
  },
  data () {
    return {
      active: 1
    }
  }
}
</script>

<style scoped>

</style>
