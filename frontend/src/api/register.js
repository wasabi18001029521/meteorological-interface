import request from '@/utils/request'

export function userregister(username, password) {
    return request({
        url: '/api/auth/register',
        method: 'post',
        data: {
            username,
            password
        }
    })
}