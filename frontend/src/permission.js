import router from './router'
import store from './store'
//import NProgress from 'nprogress' // progress bar
//import 'nprogress/nprogress.css' // progress bar style
import {Message} from 'element-ui'
import {getToken} from '@/utils/auth' // getToken from cookie
import Vue from 'vue'
import VueRouter from 'vue-router'

//NProgress.configure({ showSpinner: false })// NProgress configuration

const whiteList = ['/api/login', '/', '/api/register', '/price', '/dataTab', '/api/service', '/api/documents','/api/retrieve'] // 不重定向白名单
// 全局前置守卫
// 导航完成之前获取
router.beforeEach((to, from, next) => {

    //NProgress.start()
    if (getToken()) {
        // 即将要进入的目标路由对象
        if (to.path === '/login') {
            // 当前导航被中断 跳转一个新的导航
            next({path: '/'})
            //NProgress.done() // if current page is dashboard will not trigger	afterEach hook, so manually handle it
        } else {
            if (store.getters.userid == '' || store.getters.userid == null) {

                store.dispatch('my').then(res => { // 拉取用户信息
                    // 进入管道中的下一个钩子
                    // 只有next之后才能进行下一步
                   next()
                }).catch((err) => {
                    store.dispatch('FedLogOut').then(() => {
                        Message.error(err || 'Verification failed, please login again')
                        next({path: '/'})
                    })
                })
            } else {
                next()
            }
        }
    } else {

        if (whiteList.indexOf(to.path) !== -1) {
            next()
        } else {
            //next(`login?redirect=${to.path}`)

            next(`/`)
            // 否则全部重定向到登录页/login?redirect=${to.path}
            //  NProgress.done()
        }
        //没有 跳转到选择页面中去，配置地址
    }
})

router.afterEach(() => {
    // NProgress.done() // 结束Progress
})
