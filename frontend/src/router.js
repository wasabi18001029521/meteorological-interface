import Vue from 'vue'
import Router from 'vue-router'
import Welcome from './views/welcome'
import dataTab from './views/welcome/data.vue'

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
        }
    ]
})
