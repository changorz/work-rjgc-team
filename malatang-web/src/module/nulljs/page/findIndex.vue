<template>
<div>
  <CHeader/>
  <div id="div1">请选择查询的条件</div>
  <div>
    <Form @submit="onSubmit">
      <div>
        <Field
          readonly
          clickable
          name="time"
          :value="mydate.value"
          label="日期"
          placeholder="点击选择日期"
          @click="mydate.showCalendar = true"
          :rules="[{ required: true, message: '请选择日期' }]"
        />
        <Calendar
          v-model="mydate.showCalendar"
          @confirm="onConfirm1"
          :show-confirm="false"
          row-height="50"
        />
      </div>
      <div>
        <Field
          readonly
          clickable
          name="idleTime"
          :value="jc.value"
          label="节次"
          placeholder="点击选择节次"
          @click="jc.showPicker = true"
          :rules="[{ required: true, message: '请选择节次' }]"
        />
        <Popup v-model="jc.showPicker" position="bottom">
          <Picker
            show-toolbar
            :columns="jc.columns"
            @cancel="jc.showPicker = false"
            @confirm="onConfirm2"
          />
        </Popup>
      </div>
      <div>
        <Field
          readonly
          clickable
          name="jxlid"
          :value="jxl.value"
          label="教学楼"
          placeholder="点击选择教学楼"
          @click="jxl.showPicker = true"
          :rules="[{ required: true, message: '请选择教学楼' }]"
        />
        <Popup v-model="jxl.showPicker" position="bottom">
          <Picker
            show-toolbar
            :columns="jxl.columns"
            @cancel="jxl.showPicker = false"
            @confirm="onConfirm3"
          />
        </Popup>
      </div>
      <div style="margin: 16px;">
        <Button round block type="info" native-type="submit">
          提交
        </Button>
      </div>
    </Form>
  </div>
</div>
</template>

<script>
import { Field, Popup, Picker, Calendar, Button, Form } from 'vant'
import CHeader from './c_header'
export default {
  name: 'findIndex',
  components: {
    CHeader,
    Field,
    Popup,
    Picker,
    Calendar,
    Button,
    Form
  },
  data () {
    return {
      ctime: '',
      mydate: {
        value: '',
        showCalendar: false
      },
      jc: {
        value: '',
        showPicker: false,
        keyId: '',
        columns: [
          { keyId: 'allday', text: '全天' },
          { keyId: 'am', text: '上午' },
          { keyId: 'pm', text: '下午' },
          { keyId: 'night', text: '晚上' },
          { keyId: '0102', text: '1-2节' },
          { keyId: '0304', text: '3-4节' },
          { keyId: '0506', text: '5-6节' },
          { keyId: '0708', text: '7-8节' }
        ]
      },
      jxl: {
        value: '',
        showPicker: false,
        columns: [
          { keyId: '11', text: '第一教学楼' },
          { keyId: '12', text: '第二教学楼' },
          { keyId: '13', text: '第一实验楼(三教)' },
          { keyId: '14', text: '第二实验楼(四教)' },
          { keyId: '15', text: '图书馆' },
          { keyId: '16', text: '食堂' },
          { keyId: '17', text: '艺术楼' },
          { keyId: '18', text: '体育馆' },
          { keyId: '10', text: '校内' },
          { keyId: 'F8E5900456734FD5B02D4980BDA682F2', text: '艺术楼副楼' },
          { keyId: '2CE430AF4D78440CB5B13D36175B037C', text: '行政楼' }
        ]
      },
      params: {
        method: 'getKxJscx',
        time: '',
        idleTime: '',
        xqid: '1',
        jxlid: '',
        classroomNumber: ''
      }
    }
  },
  methods: {
    onConfirm1 (date) {
      this.mydate.value = `${date.getUTCFullYear()}-${(date.getMonth() + 1) < 10 ? '0' + (date.getMonth() + 1) : (date.getMonth() + 1)}-${date.getDate() < 10 ? ('0' + date.getDate()) : date.getDate()}`
      this.params.time = this.mydate.value
      this.mydate.showCalendar = false
    },
    onConfirm2 (value) {
      this.jc.showPicker = false
      this.jc.value = value.text
      this.params.idleTime = value.keyId
    },
    onConfirm3 (value) {
      this.jxl.showPicker = false
      this.jxl.value = value.text
      this.params.jxlid = value.keyId
    },
    onSubmit () {
      this.$router.push({ name: '空教室详情', params: this.params })
    }
  },
  created: function () {
    // 获取当天时间
    const a = ['日', '一', '二', '三', '四', '五', '六']
    const day1 = new Date()
    day1.setTime(day1.getTime())
    var s1 = '今天是 ' + day1.getFullYear() + '年' + (day1.getMonth() + 1) + '月' + day1.getDate() + '日 ' + '星期' + a[day1.getDay()]
    this.ctime = s1
  }
}
</script>

<style scoped>
  #div1{
    margin: .4rem 1rem;
    font-size: .9rem;
    color: #8e8e8e;
  }
</style>
