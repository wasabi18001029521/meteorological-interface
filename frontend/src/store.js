import Vue from 'vue'
import Vuex from 'vuex'
import user from './store/modules/user'
import getters from './store/getters'
//import store from './store'
Vue.use(Vuex)
//创建了一个小仓库
const store = new Vuex.Store({
    modules: {
        app,
        user,
    },
    getters
})





/*export default new Vuex.Store({
    getters,
    state,
    mutations
})*/
export default store
