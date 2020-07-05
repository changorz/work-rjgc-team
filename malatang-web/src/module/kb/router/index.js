import KBindex from '../page/Tabber'
import KBtable from '../page/Table'

export default [
  {
    path: '/jw/kb',
    component: KBindex,
    name: '课表查询',
    redirect: '/jw/kb/table',
    children: [
      { path: 'table', component: KBtable, name: '本周课表' }
    ]
  }
]
