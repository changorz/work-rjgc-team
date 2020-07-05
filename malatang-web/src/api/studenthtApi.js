// const hostUrl = 'http://abc.com:9002'
import http from './public'

const hostUrl = 'http://md.swxy.online'

// 获取轮播图
export const getRepair = (xh) => {
  const url = hostUrl + '/student/md/getRepair/' + xh
  return http.requestQuickGet(url)
}

// 获取全部电话号码
export const getAllPhoneCode = () => {
  const url = hostUrl + '/student/md/getAllPhoneCode'
  return http.requestQuickGet(url)
}
// 根据姓名模糊查询获取电话号码
export const findPhoneCodeByName = (name) => {
  const url = hostUrl + '/student/md/getPhoneCode/' + name
  return http.requestQuickGet(url)
}
// 查询用户反馈信息次数
export const findFeedbackCount = (openid) => {
  const url = hostUrl + `/student/md/feedback/${openid}`
  return http.requestQuickGet(url)
}
// 添加反馈信息
export const addFeedback = (param) => {
  const url = hostUrl + '/student/md/feedback'
  return http.requestPost(url, param)
}
// 查询是否评分过
export const findIsGrade = (openid) => {
  const url = hostUrl + `/student/md/grade/${openid}`
  return http.requestQuickGet(url)
}
// 用户评分
export const addGrade = (param) => {
  const url = hostUrl + '/student/md/grade'
  return http.requestPost(url, param)
}
