import request from '@/utils/request'

export function Message() {
    return request({
        url: '/user/information',
        method: 'post',
        data: {
        }
    })
}