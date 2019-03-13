import Vue from 'vue'
import Router from 'vue-router'
import Welcome from './views/welcome'
import DataTab from './views/welcome/data.vue'
import Price from './views/welcome/price.vue'
import Register from './views/welcome/Register.vue'
import Service from './views/welcome/Service.vue'
import Login from './views/welcome/Login.vue'


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
            name: 'register',
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

        }

    ]
})
