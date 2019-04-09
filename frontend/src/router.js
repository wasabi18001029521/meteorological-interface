import Vue from 'vue'
import Router from 'vue-router'
import Welcome from './views/welcome'
import DataTab from './views/conventionaldata/index.vue'
import Price from './views/price/index.vue'
import Purchase from './views/purchase/index.vue'
import Register from './views/register/index.vue'
import Service from './views/register/protocol.vue'
import Login from './views/login/index.vue'
import myMessage from './views/account/index.vue'
import Retrieve from './views/retrieve/index'
import VueRouter from 'vue-router'
import store from "./store";
import {Message} from "element-ui";
import { getToken } from '@/utils/auth' // getToken from cookie
import router from './router'
import documents from './views/documents/index.vue'



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
            path: '/purchase',
            name: 'purchase',
            component: Purchase,
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
            name: 'Message',
            component: myMessage
        },
        {
            path:'/api/retrieve',
            name:'retrieve',
            component:Retrieve
        },
        ,
        {
            path:'/api/documents',
            name:'documents',
            component:documents
        },
    ]

});

