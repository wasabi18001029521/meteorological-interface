import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import './assets/iconfont/iconfont.css'

import highcharts from 'highcharts'
import VueHighCharts from 'vue-highcharts'


/*引入资源请求插件*/
import axios from 'axios';

/*使用axios插件*/
Vue.prototype.$axios = axios;

Vue.config.productionTip = false
Vue.use(ElementUI,axios);
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')

