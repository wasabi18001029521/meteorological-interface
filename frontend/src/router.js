import Vue from 'vue'
import Router from 'vue-router'
import Welcome from './views/welcome'
import dataTab from './views/welcome/data.vue'
import Registe from '@/components/Registe.vue'
import Service from '@/components/Service.vue'

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
            component: dataTab,
            name: 'dataTab',
        },
        {
            path: '/api/registe',
            name: 'registe',
            component: Registe
        },
        {
            path: '/api/service',
            name: 'service',
            component: Service
        }
    ]
})
