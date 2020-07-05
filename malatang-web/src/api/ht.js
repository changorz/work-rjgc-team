import http from './public'

// const hostUrl = 'http://abc.com:9002'
const hostUrl = 'http://md.swxy.online'

// 获取轮播图
export const getViewPager = () => {
  const url = hostUrl + '/student/md/getViewPager'
  return http.requestQuickGet(url)
}

// 获取菜单项
export const getMenuItem = () => {
  const url = hostUrl + '/student/md/getMenuItem'
  return http.requestQuickGet(url)
}

// -------------------------------------------------------------
// 微信业务
export const getWxLoginUrl = () => {
  const url = hostUrl + '/wx/login/getUrl'
  return http.requestQuickGet(url)
}

export const getUser = (code) => {
  const url = hostUrl + `/wx/login/getInfoUser/${code}`
  return http.requestQuickGet(url)
}
