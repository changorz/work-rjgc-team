<template>
  <div v-wechat-title='this.zctitle'>
    <div>
      <table>
        <tr style="background-color: rgb(0, 0, 0); color: rgb(255, 255, 255);font-size:12px">
          <th id="box1">星期<br>日期</th>
          <th><a>周一<br>{{kbdata[0].substring(5,10)}}</a></th>
          <th><a>周二<br>{{kbdata[1].substring(5,10)}}</a></th>
          <th><a>周三<br>{{kbdata[2].substring(5,10)}}</a></th>
          <th><a>周四<br>{{kbdata[3].substring(5,10)}}</a></th>
          <th><a>周五<br>{{kbdata[4].substring(5,10)}}</a></th>
          <th><a>周六<br>{{kbdata[5].substring(5,10)}}</a></th>
          <th><a>周日<br>{{kbdata[6].substring(5,10)}}</a></th>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">8:00<br>|<br>8:45</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">8:50<br>|<br>9:35</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">9:55<br>|<br>10:40</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">10:45<br>|<br>11:30</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">14:00<br>|<br>14:45</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">14:50<br>|<br>15:35</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">15:55<br>|<br>16:40</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">16:45<br>|<br>17:30</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">19:00<br>|<br>19:45</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td style="background-color: rgb(255, 255, 255);">19:50<br>|<br>20:35</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <!--<tr>-->
        <!--    <td  style="background-color: rgb(255, 255, 255);" rowspan="2">15:55<br>|<br>16:40</td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--</tr>-->
        <!--<tr>-->

        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--</tr>-->
        <!--<tr>-->
        <!--    <td  style="background-color: rgb(255, 255, 255);" rowspan="2">第五<br>大节</td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--</tr>-->
        <!--<tr>-->

        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--</tr>-->
        <!--<tr>-->
        <!--    <td  style="background-color: rgb(255, 255, 255);" rowspan="2">第六<br>大节</td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--</tr>-->
        <!--<tr>-->

        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--    <td></td>-->
        <!--</tr>-->
      </table>
    </div>
    <div class="append">
    </div>
  </div>
</template>

<script>
import $ from 'jquery'
import * as qz from '../../../api/qz'
import { mapActions } from 'vuex'
export default {
  name: 'Table',
  data () {
    return {
      currentTime: {
        e_time: '',
        s_time: '',
        xnxqh: '',
        zc: ''
      },
      zc: 1,
      kbcxAzc: [],
      kbdat: ['', '', '', '', '', '', ''],
      today: '',
      zctitle: '课表查询'
    }
  },
  methods: {
    ...mapActions(['updataQzInfo']),
    // 渲染当天星期
    bef () {
      $(document).ready(function () {
        const $day = new Date()
        const $today = $day.getDay()
        // alert($today);
        if ($today === 0) {
          $('table th').eq(7).addClass('now')
        } else {
          $('table th').eq($today).addClass('now')
        }
        if ($(window).width() > 320) {
          $('table').css({
            width: '100%'
          })
        } else {
          $('table').css({
            width: '136%'
          })
          $('table').swipe({
            swipeLeft: function (event, direction, distance, duration, fingerCount) {
              // $(this).css("margin-left","-38%");
              $(this).animate({
                'margin-left': '-38%'
              })
            },

            swipeRight: function (event, direction, distance, duration, fingerCount) {
              // $(this).css("margin-left","0");
              $(this).animate({
                'margin-left': 0
              })
            }
          })
        }
      })
    },
    // 添加课程
    add (day, start, length, name, classroom, id) {
      if ($('table').find('tr').eq(start).find('td').eq(day).text() !== '') {
        if ($('table').find('tr').eq(start).find('td').eq(day).attr('rowspan') >= length) {
          const color = ['#13CA9A', '#BA8ADE', '#FD8C40', '#C9C9C9', '#3DB5E7', '#FFB81E', '#FF828A', '#EA69A2', '#FE3E65', '#7E57C6', '#B3D465', '#F29C77']
          var $append = $('<div></div>')
          $append.css({
            width: 0,
            height: 0,
            'border-left': '10px solid #000',
            'border-top': '10px solid' + color[id % 12],
            position: 'absolute',
            right: '0',
            top: '0'
          })
          $('table').find('tr').eq(start).find('td').eq(day).prepend($append).addClass('click')
          $('table').find('tr').eq(start + 1).find('td').eq(day).css('background', color[id % 12]).text(name + classroom)
        } else {
          const color = ['#13CA9A', '#BA8ADE', '#FD8C40', '#C9C9C9', '#3DB5E7', '#FFB81E', '#FF828A', '#EA69A2', '##F4889F', '#7E57C6', '#B3D465', '#F29C77']
          const $append = $('<div></div>')
          console.log($('table').find('tr').eq(start).find('td').eq(day).css('background-color'))
          $append.css({
            width: 0,
            height: 0,
            'border-left': '10px solid #000',
            'border-top': '10px solid',
            'border-top-color': $('table').find('tr').eq(start).find('td').eq(day).css('background-color'),
            position: 'absolute',
            right: '0',
            top: '0'
          })
          $('table').find('tr').eq(start + 1).find('td').eq(day).css('background-color', $('table').find('tr').eq(start).find('td').eq(day).css('background-color')).text($('table').find('tr').eq(start).find('td').eq(day).text())
          $('table').find('tr').eq(start).find('td').eq(day).attr({
            rowspan: length
          }).css('background', color[id % 12]).text(name + classroom)
          $('table').find('tr').eq(start).find('td').eq(day).prepend($append).addClass('click')
        }
      } else {
        const color = ['#13CA9A', '#BA8ADE', '#FD8C40', '#C9C9C9', '#3DB5E7', '#FFB81E', '#FF828A', '#EA69A2', '#FE3E65', '#7E57C6', '#B3D465', '#F29C77']
        $('table').find('tr').eq(start).find('td').eq(day).attr({
          rowspan: length
          // onclick: "javascript:window.location.href='showkb_info.php?day=" + day + "'"
        }).css('background', color[id % 12]).text(name + classroom)
        for (let i = 1; i < length; i++) {
          $('table').find('tr').eq(start + i).find('td').eq(day).hide()
        }
      }
    },
    // 清空表格
    flush () {
      $('table  td:nth-child(n+2)').html('').removeAttr('rowspan').css('background', 'none')
    },
    // 更新时间信息
    updatakbDate (today) {
      const params = {
        method: 'getCurrentTime',
        currDate: today
      }
      // 刷新数据
      qz.getQz(params, this.$store.state.qz.token).then((res) => {
        if (res.token != null && res.token === '-1') {
          console.log('token过期，updataqzinfo更新了数据')
          this.updataQzInfo()
          return
        }
        this.currentTime = res
        // 这学期周次减一了
        this.zc = this.currentTime.zc - 1
        this.flush()
        this.updatakb(this.zc)
      })
    },
    updatakb (zc) {
      const params = {
        method: 'getKbcxAzc',
        xh: this.$store.state.qz.user.useraccount,
        xnxqid: this.currentTime.xnxqh,
        zc: zc
      }
      qz.getQz(params, this.$store.state.qz.token).then(res => {
        if (res.token != null && res.token === '-1') {
          console.log('token过期，updataqzinfo更新了数据')
          this.updataQzInfo()
          return
        }
        this.kbcxAzc = res
        for (let i = 0; i < res.length; i++) {
          const kcsj = res[i].kcsj.toString()
          const kcmc = res[i].kcmc.toString()
          let kcxx = '@' + res[i].jsmc + '(' + res[i].kkzc + '周)'
          if (Number.parseInt(res[i].sjbz) === 2) {
            kcxx = '@' + res[i].jsmc + '(' + res[i].kkzc + '周)：双周'
          }
          if (Number.parseInt(res[i].sjbz) === 1) {
            kcxx = '@' + res[i].jsmc + '(' + res[i].kkzc + '周)：单周'
          }
          const yanse = kcmc.charCodeAt()
          if (Number.parseInt(res[i].sjbz) !== 0 && Number.parseInt(res[i].sjbz) % 2 !== Number.parseInt(zc) % 2) {
            continue
          }
          this.add(kcsj.charAt(0), kcsj.substring(1, 3), 2, kcmc, kcxx, yanse)
        }
      })
    },
    // 0获取当前日期,1是当前日期的下一周，-1是当前日期的上一周
    getNowFormatDate (u) {
      let date
      if (this.today === '' || u === 0) {
        date = new Date()
      }
      // 下一周
      if (this.today !== '' && u === 1) {
        date = new Date(new Date(this.today).getTime() + 1000 * 60 * 60 * 24 * 7)
      }
      // 上一周
      if (this.today !== '' && u === -1) {
        date = new Date(new Date(this.today).getTime() - 1000 * 60 * 60 * 24 * 7)
      }
      const year = date.getFullYear()
      let month = date.getMonth() + 1
      let strDate = date.getDate()
      if (month >= 1 && month <= 9) {
        month = '0' + month
      }
      if (strDate >= 0 && strDate <= 9) {
        strDate = '0' + strDate
      }
      const currentdate = year + '-' + month + '-' + strDate
      // 赋值个today
      return currentdate
    },
    // 获取当前周从星期一到星期天的日期
    getDates (currentTime) {
      const currentDate = new Date(currentTime)
      const timesStamp = currentDate.getTime()
      const currenDay = currentDate.getDay()
      const dates = []
      for (var i = 0; i < 7; i++) {
        dates.push(new Date(timesStamp + 24 * 60 * 60 * 1000 * (i - (currenDay + 6) % 7)).toLocaleDateString().replace(/\//g, '-'))
      }
      return dates
    },
    // 上一周
    befor () {
      // 修改时间today
      this.today = this.getNowFormatDate(-1)
      this.kbdata = this.getDates(this.today)
      this.flush()
      this.zc = this.zc - 1
      this.zctitle = `课表查询|第${this.zc}周`
      this.updatakb(this.zc)
    },
    // 下一周
    after () {
      this.today = this.getNowFormatDate(1)
      this.kbdata = this.getDates(this.today)
      this.flush()
      this.zc = this.zc + 1
      this.zctitle = `课表查询|第${this.zc}周`
      this.updatakb(this.zc)
    },
    // 全周 false本周，true全周
    befor_after (a) {
      if (a) {
        this.zctitle = '本周课表'
        this.today = this.getNowFormatDate(0)
        this.kbdata = this.getDates(this.today)
        this.updatakbDate(this.today)
      } else {
        this.zctitle = '课表查询|全周课表'
        this.kbdata = ['', '', '', '', '', '', '']
        for (let i = 1; i < 20; i++) {
          this.updatakb(i)
        }
      }
    }
  },
  created () {
    // 简单检测token
    const token = this.$store.state.qz.token
    if (token == null || token === '-1' || String(token).length !== 128) {
      console.log('updataqzinfo更新了数据')
      this.updataQzInfo()
    }
    // 方法必须在created中调用
    this.today = this.getNowFormatDate(0)
    this.kbdata = this.getDates(this.today)
    this.updatakbDate(this.today)
  },
  mounted () {
    // 渲染今天日期
    this.bef()
  }
}
</script>

<style scoped src="../../../assets/kdqn/static/css/timetable_bg.css"/>
<style scoped>
  html{
    background-color: rgba(244, 244, 244, 0.65);
  }
  a{
    text-decoration:none;
    color: #5A5A5A;
  }
</style>
