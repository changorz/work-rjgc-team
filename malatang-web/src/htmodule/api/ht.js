import http from '../../api/public'

// const hostUrl = 'http://abc.com:9002'
const hostUrl = 'http://md.swxy.online'

// -----------------------菜单-------------------------
// 增加菜单项
export const addMenuItem = (params) => {
  const url = hostUrl + '/admin/md/menu'
  return http.requestPost(url, params)
}

// 删除菜单项
export const deleteMenuItem = (id) => {
  const url = hostUrl + '/admin/md/menu/' + id
  return http.requestDelete(url)
}

// 修改菜单项
export const updateMenuItem = (params) => {
  const url = hostUrl + '/admin/md/menu'
  return http.requestPut(url, params)
}

// 获取所有菜单项
export const getAllMenuItem = () => {
  const url = hostUrl + '/admin/md/menu'
  return http.requestQuickGet(url)
}

// -----------------------轮播图-------------------------
// 添加轮播图
export const addViewpage = (params) => {
  const url = hostUrl + '/admin/md/viewpage'
  return http.requestPost(url, params)
}
// 删除轮播图
export const deleteViewpage = (id) => {
  const url = hostUrl + '/admin/md/viewpage/' + id
  return http.requestDelete(url)
}

// 查询轮播图
export const getAllViewpage = () => {
  const url = hostUrl + '/admin/md/viewpage'
  return http.requestQuickGet(url)
}

// -----------------------重修-------------------------
// 分页查询
export const findPage = (start, size, a, b) => {
  const url = hostUrl + `/admin/md/repair/${start}/${size}/a${a}/b${b}`
  return http.requestQuickGet(url)
}
// 按姓名或者学号查询全部
export const findPageByName = (name) => {
  const url = hostUrl + `/admin/md/repair/${name}`
  return http.requestQuickGet(url)
}
// 获取全部班级
export const getAllBj = () => {
  const url = hostUrl + '/admin/md/repair/getAllBj'
  return http.requestQuickGet(url)
}
// 获取全部课程
export const getAllKc = () => {
  const url = hostUrl + '/admin/md/repair/getAllKc'
  return http.requestQuickGet(url)
}

// -----------------------电话号码-----------------
// 分页查询
export const findPhoneCodePage = (start, size) => {
  const url = hostUrl + `/admin/md/phoneCode/${start}/${size}`
  return http.requestQuickGet(url)
}
// 添加一个号码
export const addPhoneCode = (params) => {
  const url = hostUrl + '/admin/md/phoneCode/add'
  return http.requestPost(url, params)
}
// 修改号码
export const updataPhoneCode = (params) => {
  const url = hostUrl + '/admin/md/phoneCode'
  return http.requestPut(url, params)
}
// 删除一个号码
export const deletePhoneCode = (id) => {
  const url = hostUrl + `/admin/md/phoneCode/${id}`
  return http.requestDelete(url)
}
// 删除全部号码
export const deleteAllPhoneCode = () => {
  const url = hostUrl + '/admin/md/phoneCode'
  return http.requestDelete(url)
}
// 按姓名搜索电话号码
export const findPhoneCodeByName = (name) => {
  const url = hostUrl + `/admin/md/phoneCode/${name}`
  return http.requestQuickGet(url)
}
// 更新反馈的状态
export const updataFeedback = (id, dispose) => {
  const url = hostUrl + `/admin/feefbock/${id}/${dispose}`
  return http.requestPut(url, {})
}
// 反馈-分页查询
export const findFeedbackPage = (pageStart, size) => {
  const url = hostUrl + `/admin/feefbock/${pageStart}/${size}`
  return http.requestQuickGet(url)
}
// 反馈-分页查询by状态
export const findFeedbackPageByDispose = (pageStart, size, dispose) => {
  const url = hostUrl + `/admin/feefbock/${pageStart}/${size}/${dispose}`
  return http.requestQuickGet(url)
}
