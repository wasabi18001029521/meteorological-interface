import {login, logout, getInfo} from '@/api/login'
import {userregister} from '@/api/register'
import {getToken, setToken, removeToken} from '@/utils/auth'
import {message, changepass} from '@/api/mymessage'
import {quit} from '@/api/quit'
import store from "../../store";
import CryptoJS from 'crypto-js'; //加密js


const user = {
    state: {
        token: getToken(),
        name: '',
        roles: [],
        authenticated: false,
        userid: '',
        myname: '',
        userregister: '',
        userlogin: '',
        userkey: '',
        // usertoken:''|| localStorage.getItem('usertoken'),
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
            //localStorage.setItem('authenticated', authenticated)
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
        /*   SET_USERTOKEN: (state, value) => {
               state.usertoken = value
               // 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
               localStorage.setItem('usertoken', value)
           }
   */
    },
    // encodeAesString(data,key,iv);
    // CryptoJS.AES.encrypt(loginForm.login_pass, 'secret key 123')

    actions: {

        // 登录
        Login({commit}, loginForm) {
            let password = CryptoJS.AES.encrypt(loginForm.login_pass, CryptoJS.enc.Utf8.parse('abcdef0123456789'), {
                iv: CryptoJS.enc.Utf8.parse('abcdef0123456789'),
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            })
            return new Promise((resolve, reject) => {
                login(loginForm.login_email, "" + password).then(response => {
                    setToken(response.token)
                    resolve()
                }).catch(error => {
                    console.log(error)
                    reject(error)
                })
            })
        },
        //注册
        register({commit}, registerForm) {
            let password = CryptoJS.AES.encrypt(registerForm.register_pass, CryptoJS.enc.Utf8.parse('abcdef0123456789'), {
                iv: CryptoJS.enc.Utf8.parse('abcdef0123456789'),
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            })

            return new Promise((resolve, reject) => {
                userregister(registerForm.register_email, "" + password).then(response => {
                }).catch(error => {
                    reject(error)
                })
            })
        },
        // 修改密码Message
        /*  currentPassword,
            pass,
            checkPass
        */
        updatePassword({commit}, ruleForm2) {
            let currentPassword= CryptoJS.AES.encrypt(ruleForm2.currentPassword, CryptoJS.enc.Utf8.parse('abcdef0123456789'), {
                iv: CryptoJS.enc.Utf8.parse('abcdef0123456789'),
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            });
            let pass= CryptoJS.AES.encrypt(ruleForm2.pass, CryptoJS.enc.Utf8.parse('abcdef0123456789'), {
                iv: CryptoJS.enc.Utf8.parse('abcdef0123456789'),
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            });
            let checkPass= CryptoJS.AES.encrypt(ruleForm2.checkPass, CryptoJS.enc.Utf8.parse('abcdef0123456789'), {
                iv: CryptoJS.enc.Utf8.parse('abcdef0123456789'),
                mode: CryptoJS.mode.CBC,
                padding: CryptoJS.pad.Pkcs7
            });
            return new Promise((resolve, reject) => {
                message(""+currentPassword, ""+pass, ""+checkPass).then(response => {
                }).catch(error => {
                    reject(error)
                })
            })
        },

        // ruleForm2.currentPassword, ruleForm2.pass,ruleForm2.checkPass
        // 获取用户信息
        my({commit}) {
            return new Promise((resolve, reject) => {
                changepass().then(response => {
                    commit('SET_USERID', response.data.id);
                    commit('SET_MYNAME', response.data.userName);
                    commit('SET_USERREGISTER', response.data.user_register);
                    commit('SET_USERLOGIN', response.data.user_login);
                    commit('SET_USERKEY', response.data.user_key);
                    commit('SET_AUTHENTICATED', true);
                    resolve(response)
                }).catch(error => {
                    reject(error)
                })
            })
        },
        // 前端 登出
        FedLogOut({commit}) {
            return new Promise(resolve => {
                removeToken()
                resolve()
                quit().then(response => {
                    commit('SET_AUTHENTICATED',);
                    resolve(response)
                }).catch(error => {
                        reject(error)
                    }
                )
            })
        },

    }
}

export default user
