import {login, logout, getInfo} from '@/api/login'
import {userregister} from '@/api/register'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {Message} from '@/api/mymessage'
import store from "../../store";

const user = {
    state: {
        token: getToken(),
        name: '',
        roles: [],
        authenticated: false,
        userid:'',
        myname:'',
        userregister:'',
        userlogin:'',
        userkey:''
    },

    // 修改共享数据
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
        SET_USERID: (state, value) => {
            state.userid = value
        },
        SET_USERNAME: (state, value) => {
            state.username = value
        },
        SET_MYNAME: (state, value) => {
            state.myname = value
        },
        SET_USERREGISTER: (state, value) => {
            state.userregister = value
        },
        SET_USERLOGIN: (state, value) => {
            state.userlogin = value
        },
        SET_USERKEY: (state, value) => {
            state.userkey = value
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
                    //commit('username', response.success);
             /*       console.log("123")
                    console.log(getToken(response.token))*/
                    console.log(response.username)

                    resolve()
                }).catch(error => {
                    console.log(error)
                    reject(error)
                })
            })
        },
        //注册
        register({commit}, registerForm) {

            return new Promise((resolve, reject) => {
                userregister(registerForm.register_email, registerForm.register_pass).then(response =>  {
                    //resolve()
                    //debugger;
                   //alert(response.data.msg)
               //console.log(response.username)

                }).catch(error => {
                    //console.log(error)
                    reject(error)
                })
            })
        },
        // 我的账号钩子函数调用
        my({commit}) {
            return new Promise((resolve, reject) => {
                Message().then(response =>  {
                   //console.log(response.id) //resolve()
                    commit('SET_USERID', response.id);
                    commit('SET_MYNAME', response.username);
                    commit('SET_USERREGISTER', response.user_register);
                    commit('SET_USERLOGIN', response.user_login);
                    commit('SET_USERKEY', response.user_key);
                    console.log(response.id)
                    /*console.log("123")
                    console.log(store.getters.userid)*/
                }).catch(error => {
                    //console.log(error)
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
