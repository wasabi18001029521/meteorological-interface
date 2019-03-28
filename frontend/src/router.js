import Vue from 'vue'
import Router from 'vue-router'
import Welcome from './views/welcome'
import DataTab from './views/conventionaldata/index.vue'
import Price from './views/price/index.vue'
import Register from './views/register/index.vue'
import Service from './views/register/protocol.vue'
import Login from './views/login/index.vue'
import myMessage from './views/account/index.vue'
import Retrieve from './views/retrieve/index'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'welcome',
            component: Welcome
        },
        {
            path: '/dataTab',
            name: 'dataTab',
            component: DataTab,
        },
        {
            path: '/price',
            name: 'price',
            component: Price,
        },
        {
            path: '/api/register',
            name: 'userregister',
            component: Register
        },
        {
            path: '/api/service',
            name: 'service',
            component: Service
        },
        {
            path: '/api/login',
            name: 'login',
            component: Login

        },
        {
            path: '/myMessage',
            name: 'myMessage',
            component: myMessage
        },
        {
            path:'/api/retrieve',
            name:'retrieve',
            component:Retrieve
        },
    ]
})
