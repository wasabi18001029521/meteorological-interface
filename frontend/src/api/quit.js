import request from '@/utils/request'

export function quit() {
    return request({
        url: '/user/quit',
        method: 'post',
        data: {}
    })
}