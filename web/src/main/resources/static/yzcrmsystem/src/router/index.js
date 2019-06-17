import Vue from 'vue'
import Router from 'vue-router'
import myframe from '@/components/myframe'
import datadictionary from '@/components/system/datadictionary'
import resource from '@/components/system/resource'
import login from '@/components/login'

Vue.use(Router)

export default new Router({
  name: 'router',
  mode: 'history',
  routes: [
    {
      path: '/main',
      name: 'myframe',
      component: myframe,
      meta: {
        requireAuth: true // 添加该字段，表示进入这个路由是需要登陆的
      },
      children: [
        {
          path: 'datadictionary',
          name: 'datadictionary',
          component: datadictionary
        },
        {
          path: 'resource',
          name: 'resource',
          component: resource
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: login
    }
  ]
})
