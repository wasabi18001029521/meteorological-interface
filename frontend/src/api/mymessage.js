import request from '@/utils/request'

export function changepass() {
    return request({
        url: '/user/information',
        method: 'post',
        data: {
        }
    })
}

export function Message(currentPassword,pass,checkPass) {
    return request({
        url: '/api/change/password ',
        method: 'post',
        data: {
         currentPassword,
            pass,
            checkPass
        }
    })
}
