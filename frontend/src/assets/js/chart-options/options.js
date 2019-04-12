module.exports = {
     bar: {
         chart: {
         type:'areaspline'//指定图表的类型，默认是折线图（line）
         },
         credits: {
         enabled:false
         },//去掉地址
         title: {
             text: ' ' //指定图表标题
             },
         colors: ['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5' ],
         xAxis: {
          categories: ['2019-1-31', '2019-2-3', '2019-2-14','2019-2-19','2019-2-21','2019-2-28','2019-3-4'] //指定x轴分组
         },
         yAxis: {
              title: {
              text: '次数', //指定y轴的标题
             },
               //max: '20',   //设置Y轴最大值为“max”
              //tickInterval: 4
         },
         plotOptions: {
              column: {
              colorByPoint:true
              },
          },
         series: [{
                 name: 'API访问量',
                 data: [3, 4, 3, 5, 4, 10, 12]
             }, {
                 name: '插件访问量',
                 data: [1, 3, 4, 3, 3, 5, 4]
             }]
     }
}