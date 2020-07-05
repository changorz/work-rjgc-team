<template>
  <div>
    <div>
      <form action="/">
        <van-search
          v-model="input"
          show-action
          placeholder="请输入搜索关键词"
          @input="onSearch"
          @cancel="onCancel"
        />
      </form>
    </div>
    <van-index-bar>
      <div v-if="flag">
        <div v-for="(item, index) in phoneCodeList1" :key="index">
          <van-index-anchor :index=index v-if="item.length!=0" /> <!--v-if="item==null"-->
          <div v-for="(val, i) in item" :key="i">
            <van-cell :title="val.name">
              <a :href="'tel:' + val.number"><van-icon name="phone-o" /></a>
            </van-cell>
          </div>
        </div>
      </div>

      <div v-if="!flag">
        <div v-for="(item, index) in phoneCodeList2" :key="index">
          <van-cell :title="item.name">
            <a :href="'tel:' + item.number"><van-icon name="phone-o"/></a>
          </van-cell>
        </div>
      </div>

    </van-index-bar>
  </div>
</template>

<script>
import Vue from 'vue'
import { IndexBar, IndexAnchor, Cell, Icon, Toast, Search } from 'vant'
import * as ht from '../../../api/studenthtApi'
Vue.use(IndexBar)
Vue.use(IndexAnchor)
Vue.use(Cell)
Vue.use(Icon)
Vue.use(Search)
export default {
  comments: {
    IndexBar, IndexAnchor, Cell, Toast
  },
  data () {
    return {
      phoneCodeList1: {},
      phoneCodeList2: {},
      input: '',
      // 控制div搜索时隐藏
      flag: true
    }
  },
  methods: {
    onSearch (val) {
      if (val === '') {
        this.flag = true
      } else {
        ht.findPhoneCodeByName(val).then(res => {
          this.phoneCodeList2 = res.queryResult.list
        })
        this.flag = false
      }
    },
    onCancel () {
      Toast('已取消')
      this.updata()
    },
    updata () {
      ht.getAllPhoneCode().then(res => {
        this.phoneCodeList1 = res.result
      })
    }
  },
  beforeCreate () {
    ht.getAllPhoneCode().then(res => {
      this.phoneCodeList1 = res.result
    })
  }
}
</script>
<style scoped>

</style>
