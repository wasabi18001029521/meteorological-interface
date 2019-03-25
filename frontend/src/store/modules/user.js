import {login, logout, getInfo} from '@/api/login'
import {getToken, setToken, removeToken} from '@/utils/auth'

const user = {
    state: {
        token: getToken(),
        name: '',
        roles: [],
        authenticated: false
    },

    mutations: {
        SET_TOKEN: (state, token) => {
            state.token = token
        },
        SET_NAME: (state, name) => {
            state.name = name
        },
        SET_ROLES: (state, roles) => {
            state.roles = roles
        },
        SET_AUTHENTICATED: (state, authenticated) => {
            state.authenticated = authenticated
        },
    },

    actions: {
        // 登录
        Login({commit}, loginForm) {

            return new Promise((resolve, reject) => {
                login(loginForm.login_email, loginForm.login_pass).then(response => {
                    console.log(response.token)
                    setToken(response.token)
                    commit('SET_TOKEN', response.token);
                    commit('SET_AUTHENTICATED', response.success);
                    resolve()
                }).catch(error => {
                    console.log(error)
                    reject(error)
                })
            })
        },

        // 获取用户信息
        GetInfo({commit, state}) {
            return new Promise((resolve, reject) => {
                getInfo(state.token).then(response => {
                    const data = response.data
                    if (data.roles && data.roles.length > 0) { // 验证返回的roles是否是一个非空数组
                        commit('SET_ROLES', data.roles)
                    } else {
                        reject('getInfo: roles must be a non-null array !')
                    }
                    commit('SET_NAME', data.name)
                    commit('SET_AVATAR', data.avatar)
                    resolve(response)
                }).catch(error => {
                    reject(error)
                })
            })
        },

        // 登出
        LogOut({commit, state}) {
            return new Promise((resolve, reject) => {
                logout(state.token).then(() => {
                    commit('SET_TOKEN', '')
                    commit('SET_ROLES', [])
                    removeToken()
                    resolve()
                }).catch(error => {
                    reject(error)
                })
            })
        },

        // 前端 登出
        FedLogOut({commit}) {
            return new Promise(resolve => {
                commit('SET_TOKEN', '')
                removeToken()
                resolve()
            })
        }
    }
}

export default user
