// 获取共享数据
const getters = {
    token: state => state.user.token,
    name: state => state.user.name,
    roles: state => state.user.roles,
    authenticated: state => state.user.authenticated,
    userid: state => state.user.userid,
    myname: state => state.user.myname,
    userregister: state => state.user.userregister,
    userlogin: state => state.user.userlogin,
    userkey: state => state.user.userkey,
    //usertoken: (state) => state.user.usertoken
}
export default getters
