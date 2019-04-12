exports.tableData = function (type){
  var tableData = null;
  if(type == "autoArea"){
     tableData = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
        {name: 'maxLon', type: 'number',must: '是',remarks:'最大经度'},
        {name: 'maxLat',type: 'number', must: '是',remarks:'最大纬度'},
        {name: 'minLon',type: 'number',must: '是',remarks:'最小经度'},
        {name: 'minLat',type: 'number', must: '是',remarks:'最小纬度'},
        {name: 'var',type: 'array', must: '是',remarks:'查询的字段数组'},
        {name: 'datatime',type: 'string', must: '是',remarks:'数据时间，格式 yyyyMMddHH，如果不传默认取最新的'},
        {name: 'format',type: 'string', must: '否',remarks:'时间格式，默认yyyyMMddHHmmss'},
     ];
  }else if(type == "autoOne"){
    tableData = [{name: 'sid', type: 'string', must: '是', remarks:'站点编号' },
        {name: 'elems', type: 'array',must: '是',remarks:'查询的列数组'},
        {name: 'start',type: 'string', must: '是',remarks:'开始时间，格式 yyyyMMddHH'},
        {name: 'end',type: 'number',must: '是',remarks:'结束时间，格式 yyyyMMddHH'}];
  }else if(type == "autoNearest"){
     tableData = [{name: 'lon', type: 'number', must: '是', remarks:'经度' },
        {name: 'lat', type: 'number',must: '是',remarks:'纬度'},
        {name: 'start',type: 'string', must: '是',remarks:'开始时间，格式 yyyyMMddHH'},
        {name: 'end',type: 'string',must: '是',remarks:'结束时间，格式 yyyyMMddHH'},
        {name: 'elems',type: 'array',must: '是',remarks:'查询的字段数组'},
     ];
  }else if(type == "cityArea"){
     tableData = [{name: 'maxLon', type: 'number', must: '是', remarks:'最大经度' },
        {name: 'maxLat', type: 'number',must: '是',remarks:'最大纬度'},
        {name: 'minLon',type: 'number', must: '是',remarks:'最小经度'},
        {name: 'minLat',type: 'number',must: '是',remarks:'最小纬度'},
        {name: 'var',type: 'array',must: '是',remarks:'查询的字段数组'},
        {name: 'basetime',type: 'string',must: '否',remarks:'起报时间，格式 yyyyMMddHH，如果不传默认取最新的'},
        {name: 'datatime',type: 'string',must: '是',remarks:'数据时间，格式 yyyyMMddHH'},
        {name: 'format',type: 'string',must: '否',remarks:'时间格式，默认yyyyMMddHHmmss'},
     ];
  }else if(type == "cityOne"){
     tableData = [{name: 'sid', type: 'string', must: '是', remarks:'站点编号' },
        {name: 'elems', type: 'array',must: '是',remarks:'查询的列数组'},
        {name: 'basetime',type: 'string', must: '否',remarks:'起报时间，格式 yyyyMMddHH，如果不传默认取最新的'},
        {name: 'start',type: 'string',must: '是',remarks:'开始时间，格式 yyyyMMddHH'},
        {name: 'end',type: 'string',must: '是',remarks:'结束时间，格式 yyyyMMddHH'}
     ];
  }
  return tableData;
}
exports.Result = function (type){
    var resultData = null;
    if(type == "autoArea"){
        resultData = {"id": "WZ0KQ36Y0N4N","name": "丹东","country": "CN","path": "丹东,辽宁","timezone": "Asia/Shanghai"}
    }else if(type == "autoOne"){
        resultData = {"id": "WXPFPURBXCPF","name": "大鹿岛","path": "大鹿岛,辽宁",}
    }else if(type == "autoNearest"){
        resultData = {"time": "2018-03-27T04:36:00+08:00","height": "415.45","type": "high"}
    }else if(type == "cityArea"){
        resultData = {"id": "WXPGQ4MXZGGS","name": "石山子","path": "石山子,辽宁","latitude": "39.96","longitude": "123.67",}
    }else if(type == "cityOne"){
        resultData = {"id": "WZ0KQC3Q4N5N","name": "丹东","path": "丹东,辽宁","latitude": "40.13","longitude": "124.40"}
    }
    return resultData;
}