import http from './public'
// 强智的url
const url = '/znlykjdxswxy/app.do'
// 通过账号密码，获取基本的用户信息
export const getQzInfo = (params) => {
  return http.requestGet(url, { params: params })
}

export const getQz = (params, token) => {
  return http.requestGet(url, { params: params, headers: { token: token } })
}
