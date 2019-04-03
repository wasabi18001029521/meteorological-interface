import router from './router'
import store from './store'
//import NProgress from 'nprogress' // progress bar
//import 'nprogress/nprogress.css' // progress bar style
import { Message } from 'element-ui'
import { getToken } from '@/utils/auth' // getToken from cookie
import Vue from 'vue'
import VueRouter from 'vue-router'

//NProgress.configure({ showSpinner: false })// NProgress configuration

const whiteList = ['/api/login','/'] // 不重定向白名单
router.beforeEach((to, from, next) => {

  //NProgress.start()
  console.log("导航守卫启动了")
  if (getToken()) {

    if (to.path === '/login') {
      next({ path: '/' })

      //NProgress.done() // if current page is dashboard will not trigger	afterEach hook, so manually handle it
    } else {

      //store.getters.roles.length === 0
console.log(store.getters.userid)
      if (store.getters.userid == ''||store.getters.userid == null) {

        store.dispatch('my').then(res => { // 拉取用户信息
          //next()
          next({ path: 'http://localhost:8080/#/' })
        }).catch((err) => {
          store.dispatch('FedLogOut').then(() => {
            Message.error(err || 'Verification failed, please login again')
            next({ path: '/' })

          })
        })
      } else {
        next()
      }
    }
  } else {
    //console.log(whiteList.indexOf(to.path))

    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next(`login?redirect=${to.path}`) // 否则全部重定向到登录页/login?redirect=${to.path}
      //NProgress.done()
    }
    //没有 跳转到选择页面中去，配置地址

  }
})

router.afterEach(() => {
 // NProgress.done() // 结束Progress
})
