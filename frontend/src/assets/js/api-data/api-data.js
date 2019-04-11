exports.tableData = function (type){
  var data = null;
  if(type == "autoArea"){
     data = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
        {name: 'maxLon', type: 'number',must: '是',remarks:'最大经度'},
        {name: 'maxLat',type: 'number', must: '是',remarks:'最大纬度'},
        {name: 'minLon',type: 'number',must: '是',remarks:'最小经度'},
        {name: 'minLat',type: 'number', must: '是',remarks:'最小纬度'},
        {name: 'var',type: 'array', must: '是',remarks:'查询的字段数组'},
        {name: 'datatime',type: 'string', must: '是',remarks:'数据时间，格式 yyyyMMddHH，如果不传默认取最新的'},
        {name: 'format',type: 'string', must: '否',remarks:'时间格式，默认yyyyMMddHHmmss'},
     ];
  }else if(type == "autoOne"){
    data = [{name: 'sid', type: 'string', must: '是', remarks:'站点编号' },
        {name: 'elems', type: 'array',must: '是',remarks:'查询的列数组'},
        {name: 'start',type: 'string', must: '是',remarks:'开始时间，格式 yyyyMMddHH'},
        {name: 'end',type: 'number',must: '是',remarks:'结束时间，格式 yyyyMMddHH'}];
  }else if(type == "autoNearest"){
     data = [{name: 'lon', type: 'number', must: '是', remarks:'经度' },
        {name: 'lat', type: 'number',must: '是',remarks:'纬度'},
        {name: 'start',type: 'string', must: '是',remarks:'开始时间，格式 yyyyMMddHH'},
        {name: 'end',type: 'string',must: '是',remarks:'结束时间，格式 yyyyMMddHH'},
        {name: 'elems',type: 'array',must: '是',remarks:'查询的字段数组'},
     ];
  }else if(type == "cityArea"){
     data = [{name: 'maxLon', type: 'number', must: '是', remarks:'最大经度' },
        {name: 'maxLat', type: 'number',must: '是',remarks:'最大纬度'},
        {name: 'minLon',type: 'number', must: '是',remarks:'最小经度'},
        {name: 'minLat',type: 'number',must: '是',remarks:'最小纬度'},
        {name: 'var',type: 'array',must: '是',remarks:'查询的字段数组'},
        {name: 'basetime',type: 'string',must: '否',remarks:'起报时间，格式 yyyyMMddHH，如果不传默认取最新的'},
        {name: 'datatime',type: 'string',must: '是',remarks:'数据时间，格式 yyyyMMddHH'},
        {name: 'format',type: 'string',must: '否',remarks:'时间格式，默认yyyyMMddHHmmss'},
     ];
  }else if(type == "cityOne"){
     data = [{name: 'sid', type: 'string', must: '是', remarks:'站点编号' },
        {name: 'elems', type: 'array',must: '是',remarks:'查询的列数组'},
        {name: 'basetime',type: 'string', must: '否',remarks:'起报时间，格式 yyyyMMddHH，如果不传默认取最新的'},
        {name: 'start',type: 'string',must: '是',remarks:'开始时间，格式 yyyyMMddHH'},
        {name: 'end',type: 'string',must: '是',remarks:'结束时间，格式 yyyyMMddHH'}
     ];
  }
  return data;
}