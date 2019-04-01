import request from '@/utils/request'

export function myusername() {
    return request({
        url: '/user/information',
        method: 'post',
        data: {
        }
    })
}