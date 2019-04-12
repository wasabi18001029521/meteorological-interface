import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import './assets/iconfont/iconfont.css'

import highcharts from 'highcharts'
import VueHighCharts from 'vue-highcharts'
import '@/permission' // permission control
import axios from 'axios';

import codemirror  from 'vue-codemirror'
import 'codemirror/lib/codemirror.css'
Vue.use(codemirror)

Vue.prototype.$axios = axios;


Vue.config.productionTip = false
Vue.use(ElementUI);
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')

