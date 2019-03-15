// module.exports = {
//     devServer: {
//         proxy: {
//             '/weather': {
//                 target: 'http://localhost:8080/weather', //对应自己的接口
//                 changeOrigin: true,
//                 ws: true,
//                 pathRewrite: {
//                     '^/weather': ''
//                 }
//             }
//         }
//     }
// }