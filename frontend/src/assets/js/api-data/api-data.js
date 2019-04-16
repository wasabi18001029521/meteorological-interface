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
            "location": "",
            "level": "1",
            "maxLon": "38.2",
            "maxLat": "24.7",
            "minLon": "22.22",
            "now": "",
            "datatime ": "//数据时间",
            "dt": "//露点温度",
            "lonlat": "//经纬度[经度,纬度]",
            "p": "气压",
            "prec_1h": "//过去1小时降水量",
            "rh ": "//相对湿度",
            "slp ": "//海平面气压",
            "staCode ": "//站点编号",
            "t ": "//气温",
            "wd ": "//风向",
            "ws ": "//风速"
        }
    } else if (type == "autoOne") {
        resultData = {
            "location": "",
            "sid": "2",
            "elems": "[1,2]",
            "start": "2019-04-10 12",
            "end": "2019-04-11 12",
            "now": "",
            "datatime ": "//数据时间",
            "dt": "//露点温度",
            "lonlat ": "//经纬度[经度，纬度]",
            "p ": "//气压",
            "prec_1h": "//过去1小时降水量",
            "rh": "//相对湿度",
            "slp ": "//海平面气压",
            "staCode ": "//站点编号",
            "t": "//气温",
            "wd ": "//风向",
            "ws ": "//风速"


        }
    } else if (type == "autoNearest") {
        resultData = {
            "location": "",
            "lon": "31.21",
            "lat": "22.12",
            "start": "2019-04-10 12",
            "end": "2019-04-11 12",
            "elems": "[1,2]",
            "now": "",
            "datatime ": "//数据时间",
            "dt ": "//露点温度",
            "lonlat ": "://经纬度[经度，纬度]",
            "p ": "//气压",
            "prec_1h": "//过去1小时降水量",
            "rh ": "//相对湿度",
            "slp ": "//海平面气压",
            "staCode ": "//站点编号",
            "t ": "//气温",
            "wd ": "//风向",
            "ws ": "//风速"


        }
    } else if (type == "cityArea") {
        resultData = {
            "location": "",
            "maxLon": "22.22",
            "maxLat": "33.33",
            "minLon": "11.11",
            "minLat": "2.22",
            "var": "[1,2]",
            "datatime": "数据时间，格式 yyyyMMddHH",
            "now": "",
            "basetime ": "//起报时间",
            "datatime ": "//数据时间",
            "lcc ": "//低云量",
            "lonlat ": "//经纬度[经度，纬度]",
            "p": "//气压",
            "prec ": "//降水量",
            "rh ": "//相对湿度",
            "staCode ": "//站点编号",
            "t": "//气温",
            "tcc ": "//总云量",
            "vis ": "//能见度",
            "wd ": "//风向",
            "wp ": "//天气现象编码",
            "ws ": "//风速"


        }
    } else if (type == "cityOne") {
        resultData = {
            "location": "",
            "sid": "2",
            "elems": "[1,2]",
            "start": "2019-04-10 12",
            "end": "2019-04-10 12",
            "now": "",
            "basetime ": "//起报时间",
            "datatime ": "数据时间",
            "lcc ": "//低云量",
            "lonlat ": "//经纬度[经度，纬度]",
            "p": "//气压",
            "prec": "//降水量",
            "rh": "//相对湿度",
            "staCode": "//站点编号",
            "t ": "//气温",
            "tcc ": "//总云量",
            "vis ": "//能见度",
            "wd ": "//风向",
            "wp ": "//天气现象编码",
            "ws ": "//风速"
        }
    }
    return resultData;
}