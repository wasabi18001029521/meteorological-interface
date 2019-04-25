exports.tableData = function (type) {
    var tableData = null;
    if (type == "autoArea") {
        tableData = [{name: 'level', type: 'integer', must: '是', remarks: '抽稀级别 [1,2,3,4]'},
            {name: 'maxLon', type: 'number', must: '是', remarks: '最大经度'},
            {name: 'maxLat', type: 'number', must: '是', remarks: '最大纬度'},
            {name: 'minLon', type: 'number', must: '是', remarks: '最小经度'},
            {name: 'minLat', type: 'number', must: '是', remarks: '最小纬度'},
            {name: 'var', type: 'array', must: '是', remarks: '查询的字段数组'},
            {name: 'datatime', type: 'string', must: '是', remarks: '数据时间，格式 yyyyMMddHH，如果不传默认取最新的'},
            {name: 'format', type: 'string', must: '否', remarks: '时间格式，默认yyyyMMddHHmmss'},
        ];
    } else if (type == "autoOne") {
        tableData = [{name: 'sid', type: 'string', must: '是', remarks: '站点编号'},
            {name: 'elems', type: 'array', must: '是', remarks: '查询的列数组'},
            {name: 'start', type: 'string', must: '是', remarks: '开始时间，格式 yyyyMMddHH'},
            {name: 'end', type: 'number', must: '是', remarks: '结束时间，格式 yyyyMMddHH'}];
    } else if (type == "autoNearest") {
        tableData = [{name: 'lon', type: 'number', must: '是', remarks: '经度'},
            {name: 'lat', type: 'number', must: '是', remarks: '纬度'},
            {name: 'start', type: 'string', must: '是', remarks: '开始时间，格式 yyyyMMddHH'},
            {name: 'end', type: 'string', must: '是', remarks: '结束时间，格式 yyyyMMddHH'},
            {name: 'elems', type: 'array', must: '是', remarks: '查询的字段数组'},
        ];
    } else if (type == "cityArea") {
        tableData = [{name: 'maxLon', type: 'number', must: '是', remarks: '最大经度'},
            {name: 'maxLat', type: 'number', must: '是', remarks: '最大纬度'},
            {name: 'minLon', type: 'number', must: '是', remarks: '最小经度'},
            {name: 'minLat', type: 'number', must: '是', remarks: '最小纬度'},
            {name: 'var', type: 'array', must: '是', remarks: '查询的字段数组'},
            {name: 'basetime', type: 'string', must: '否', remarks: '起报时间，格式 yyyyMMddHH，如果不传默认取最新的'},
            {name: 'datatime', type: 'string', must: '是', remarks: '数据时间，格式 yyyyMMddHH'},
            {name: 'format', type: 'string', must: '否', remarks: '时间格式，默认yyyyMMddHHmmss'},
        ];
    } else if (type == "cityOne") {
        tableData = [{name: 'sid', type: 'string', must: '是', remarks: '站点编号'},
            {name: 'elems', type: 'array', must: '是', remarks: '查询的列数组'},
            {name: 'basetime', type: 'string', must: '否', remarks: '起报时间，格式 yyyyMMddHH，如果不传默认取最新的'},
            {name: 'start', type: 'string', must: '是', remarks: '开始时间，格式 yyyyMMddHH'},
            {name: 'end', type: 'string', must: '是', remarks: '结束时间，格式 yyyyMMddHH'}
        ];
    }
    return tableData;
}
exports.Result = function (type) {
    var resultData = null;
    if (type == "autoArea") {
        resultData = {
            "Success Model": {
               "datatime" : "2015-09-25 07:00",//数据更新时间（该城市的本地时间）
                "dt" :"4",//露点温度,单位为c摄氏度或f华氏度
                "lonlat" : "[160.40,39.90]",//经纬度[经度，纬度]
                "p": "1007.6",//'气压,单位为mb百帕或in英寸
                "prec_1h": "20",//过去1小时降水量,单位mm毫米
                "rh": "40%",//相对湿度,0~100，单位为百分比
                "slp": "56",//海平面气压
                "staCode": "2018",//站点编号
                "t": "3",//气温，单位为c摄氏度或f华氏度
                "wd": "东风",//风向文字
                "ws": "12"//风速，单位为km/h公里每小时或mph英里每小时
            },
            "Error Model": {
            "errorCode": "string",//错误代码
            "errorInfo": "string"//错误信息
        }
        }
    } else if (type == "autoOne") {
        resultData = {
            "Success Model": {
                "datatime ":"2015-09-25 08:00", //数据时间
                "dt": "8",//露点温度
                "lonlat ": "[180.40,50.90]",//经纬度[经度，纬度]
                "p ": "1200.3",//气压
                "prec_1h": "23",//过去1小时降水量
                "rh": "56",//相对湿度
                "slp ": "59",//海平面气压
                "staCode ": "2",//站点编号
                "t": "16",//气温
                "wd ": "东北",//风向
                "ws ": "18"//风速
            },
            "Error Model":{
            "errorCode": "string",//错误代码
            "errorInfo": "string"//错误信息
        }
        }
    } else if (type == "autoNearest") {
        resultData = {
            "Success Model": {
                "datatime ": "2015-09-25 08:00",//数据时间
                "dt ": "9",//露点温度
                "lonlat ": "[180.40,50.90]",//经纬度[经度，纬度]
                "p ": "1200.6",//气压
                "prec_1h": "25",//过去1小时降水量
                "rh ": "58",//相对湿度
                "slp ": "100",//海平面气压
                "staCode ": "3",//站点编号
                "t ": "1007.6",//气压
                "wd ": "东北",//风向
                "ws ": "23"//风速
            },
            "Error Model":{
                "errorCode": "string",//错误代码
                "errorInfo": "string"//错误信息
            }
        }
    } else if (type == "cityArea") {
        resultData = {
            "Success Model": {
                "basetime ": "2019-04-22 18:00",//起报时间
                "datatime ": "2019-04-22 18:00",//数据时间
                "lcc ": "5",//低云量
                "lonlat ": "[180.40,50.90]",//经纬度[经度，纬度]
                "p": "1007.6",//气压
                "prec ": "33",//降水量
                "rh ": "46",//相对湿度
                "staCode ": "3",//站点编号
                "t": "15",//气温
                "tcc ": "0",//总云量
                "vis ": "20",//能见度
                "wd ": "东南",//风向
                "wp ": "01",//天气现象编码，01少云
                "ws ": "16"//风速
            },
            "Error Model":{
                "errorCode": "string",//错误代码
                "errorInfo": "string"//错误信息
            }
        }
    } else if (type == "cityOne") {
        resultData = {
            "Success Model": {
            "basetime ": "2019-4-25 8:00",//起报时间
            "datatime ": "2019-4-25 9:00",//数据时间
            "lcc ": "8",//低云量
            "lonlat ": "[180.40,50.90]",//经纬度[经度，纬度]
            "p": "1008.6",//气压
            "prec": "31",//降水量
            "rh": "42",//相对湿度
            "staCode": "2",//站点编号
            "t ": "24",//气温
            "tcc ": "0",//总云量
            "vis ": "20",//能见度
            "wd ": "南",//风向
            "wp ": "02",//天气现象编码
            "ws ": "13"//风速
        },
            "Error Model":{
                "errorCode": "string",//错误代码
                "errorInfo": "string"//错误信息
            }
        }
    }
    return resultData;
}