// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import iView from 'iview'
import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import 'iview/dist/styles/iview.css'

Vue.use(iView)
Vue.use(VueResource)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
if (module.hot) {
  module.hot.accept()
}

/**
 * vue-resource 拦截器配置
 **/
Vue.http.interceptors.push((request, next) => {
  request.method = 'POST'
  request.headers.set('Content-Type', 'application/json;charset=UTF-8')
  next((response) => {
    console.log(response)
    return response
  })
})

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requireAuth)) {
    if (localStorage.user_id) {
      next()
    } else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})
