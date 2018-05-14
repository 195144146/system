import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import myframe from '@/components/myframe'
import list from '@/components/list'
import buttion from '@/components/buttion'
import dataDictionary from '@/components/datadictionary/DataDictionary'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/main',
      name: 'myframe',
      component: myframe,
      children: [
        {
          path: 'list',
          name: 'list',
          component: list
        },
        {
          path: 'buttion',
          name: 'buttion',
          component: buttion
        },
        {
          path: 'dataDictionary',
          name: 'dataDictionary',
          component: dataDictionary
        }
      ]
    }
  ]
})
