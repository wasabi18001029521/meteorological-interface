const getters = {
    token: state => state.user.token,
    name: state => state.user.name,
    roles: state => state.user.roles,
    authenticated: state => state.user.authenticated
}
export default getters
