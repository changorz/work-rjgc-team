<template>
  <div>
    <div id="lab1">
      <label>涉外学院-作息时间</label>
    </div>
    <div>
      <van-steps direction="vertical">
        <van-step>
          <h3>1-2节</h3>
          <p>8:00-9:40</p>
        </van-step>
        <van-step>
          <h3>3-4节</h3>
          <p>9:55-11:35</p>
        </van-step>
        <van-step>
          <h3>5-6节</h3>
          <p>14:00-15:20</p>
        </van-step>
        <van-step>
          <h3>7-8节</h3>
          <p>14:30-17:00</p>
        </van-step>
        <van-step>
          <h3>9-10节</h3>
          <p>8:00-9:40</p>
        </van-step>
        <van-step>
          <h3>熄灯</h3>
          <p>23:30</p>
        </van-step>
      </van-steps>
    </div>
  </div>
</template>
<script>
import Vue from 'vue'
import { Step, Steps } from 'vant'
Vue.use(Step)
Vue.use(Steps)
export default {
}
</script>

<style scoped>
  #lab1{
    font-size: 1.6em;
    font-family: 宋体;
    color: #3cc51f;
    margin: 1em 0 1em 4em;
  }
</style>
