<template>
    <el-container class="u-documents-box">
     <el-main>
        <el-row>
          <el-col :span="7">
            <el-aside class="u-document-nav" width="360px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1', '3']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>API开发文档</template>
                        <el-submenu index="1-4">
                            <template slot="title">中国地面自动站</template>
                            <el-menu-item index="1-4-1" @click="changeAPI('autoArea')">中国地面自动站区域查询数据获取接口</el-menu-item>
                            <el-menu-item index="1-4-2" @click="changeAPI('autoOne')">中国地面自动站单站查询数据获取接口</el-menu-item>
                            <el-menu-item index="1-4-3" @click="changeAPI('autoNearest')">中国地面自动站最近站数据获取接口</el-menu-item>
                        </el-submenu>
                        <el-submenu index="2-4">
                            <template slot="title">精细化城市预报</template>
                            <el-menu-item index="2-4-1" @click="changeAPI('cityArea')">精细化城市预报矩形区域查询数据获取接口</el-menu-item>
                            <el-menu-item index="2-4-2" @click="changeAPI('cityOne')">精细化城市预报单站查询数据获取接口</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-menu"></i>账号相关问题</template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="2-1">选项1</el-menu-item>
                            <el-menu-item index="2-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="2-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="2-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="2-4-1">选项4-1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title"><i class="el-icon-setting"></i>产品相关问题</template>
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="3-1">选项1</el-menu-item>
                            <el-menu-item index="3-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="3-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="3-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="3-4-1">选项4-1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                </el-menu>
            </el-aside>
          </el-col>
          <el-col :span="15">
            <div class="u-document-con">
                <div class="u-title u-size16">
                    <span  v-if="apiType === 'autoArea'">中国地面自动站区域查询数据获取接口</span>
                    <span  v-if="apiType === 'autoOne'">中国地面自动站单站查询数据获取接口</span>
                    <span  v-if="apiType === 'autoNearest'">中国地面自动站最近站数据获取接口</span>
                    <span  v-if="apiType === 'cityArea'">精细化城市预报矩形区域查询数据获取接口</span>
                    <span  v-if="apiType === 'cityOne'">精细化城市预报单站查询数据获取接口</span>
                    <span class="u-line"></span>
                </div>
                <div class="ieKsWY">
                    <span  v-if="apiType === 'autoArea'">GET /station/auto/area/</span>
                    <span  v-if="apiType === 'autoOne'">/life/suggestion.json</span>
                    <span  v-if="apiType === 'autoNearest'">/life/chinese_calendar.json</span>
                    <span  v-if="apiType === 'cityArea'">/life/driving_restriction.json</span>
                    <span  v-if="apiType === 'cityOne'">/geo/moon.json</span>
                </div>
                <div class="u-describe">根据输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国地面气象站逐小时观测数据，并提供分级抽希功能。</div>
                <div class="u-tips">请求地址试例</div>
                <div class="u-describe">矩形区域范围内,中国地面气象站逐小时观测数据
                    <span class="u-orange">https://localhost:8080/station/auto/area?key=your_api_key&level=1&maxLon=22.22&maxLat=22.22 &minLon=22.22&minLat=22.22&var=[1,2]&datatime=2019-04-03 10:13:55&format=2019-04-09 02:01:58</span></div>
                <div class="u-tips">参数</div>
                <el-table :data="tableData" :header-cell-style="{background:'#eef1f6',color:'#606266'}" style="width: 100%">
                    <el-table-column prop="name" label="参数名" align="center"></el-table-column>
                    <el-table-column prop="type" label="类型" align="center"></el-table-column>
                    <el-table-column prop="must" label="必须" align="center"></el-table-column>
                    <el-table-column prop="remarks" label="备注" align="center"></el-table-column>
                </el-table>
                <div class="u-tips">返回结果</div>
                <div class="u-result">
                    <div><i>1</i><span>{</span></div>
                    <div><i>2</i><span class="u-B50000">"results": </span><span>[{</span></div>
                    <div><i>3</i><span  class="u-FE5400">"location":</span><span> {</span></div>
                    <div><i>4</i><span  class="u-FE5400">"id": </span><span class="u-B50000">"WX4FBXXFKE4F",</span></div>
                    <div><i>5</i><span  class="u-FE5400">"name":</span><span class="u-B50000"> "北京",</span></div>
                    <div><i>6</i><span  class="u-FE5400"> "country":</span><span class="u-B50000"> "CN",</span></div>
                    <div><i>7</i><span  class="u-FE5400"> "path": </span><span class="u-B50000">"北京,北京,中国",</span></div>
                    <div><i>8</i><span  class="u-FE5400"> "timezone": </span><span class="u-B50000">"Asia/Shanghai",</span></div>
                    <div><i>9</i><span  class="u-FE5400"> "timezone_offset":</span><span class="u-B50000"> "+08:00"</span></div>
                    <div><i>10</i><span class="u-padding30">   },</span></div>
                    <div><i>11</i><span class="u-padding20">   }]</span></div>
                    <div><i>12</i><span>   }</span></div>
                </div>
            </div>
          </el-col>
        </el-row>
     </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "autoarea",
       data(){
        return {
            apiType:'autoArea',
            tableData:[{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
                       {name: 'maxLon', type: 'number',must: '是',remarks:'1'},
                       {name: 'maxLat',type: 'number', must: '是',remarks:'1'},
                        {name: 'minLon',type: 'number',must: '是',remarks:'1'}],

       }
    },
        methods: {
            changeAPI(type){
                if(type == "autoArea"){
                    this.apiType='autoArea'
                    this.tableData = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
                     {name: 'maxLon', type: 'number',must: '是',remarks:'1'},
                      {name: 'maxLat',type: 'number', must: '是',remarks:'1'},
                      {name: 'minLon',type: 'number',must: '是',remarks:'1'}];
                }else if(type == "autoOne"){
                    this.apiType='autoOne'
                     this.tableData = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
                     {name: 'maxLon', type: 'number',must: '是',remarks:'2'},
                     {name: 'maxLat',type: 'number', must: '是',remarks:'2'},
                     {name: 'minLon',type: 'number',must: '是',remarks:'2'}];
                }else if(type == "autoNearest"){
                    this.apiType='autoNearest'
                    this.tableData = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
                    {name: 'maxLon', type: 'number',must: '是',remarks:'3'},
                    {name: 'maxLat',type: 'number', must: '是',remarks:'3'},
                    {name: 'minLon',type: 'number',must: '是',remarks:'3'}];
                }else if(type == "cityArea"){
                    this.apiType='cityArea'
                     this.tableData = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
                     {name: 'maxLon', type: 'number',must: '是',remarks:'4'},
                     {name: 'maxLat',type: 'number', must: '是',remarks:'4'},
                      {name: 'minLon',type: 'number',must: '是',remarks:'4'}];
                }else if(type == "cityOne"){
                    this.apiType='cityOne'
                     this.tableData = [{name: 'level', type: 'integer', must: '是', remarks:'抽稀级别 [1,2,3,4]' },
                     {name: 'maxLon', type: 'number',must: '是',remarks:'5'},
                     {name: 'maxLat',type: 'number', must: '是',remarks:'5'},
                     {name: 'minLon',type: 'number',must: '是',remarks:'5'}];
                }
            },


        },


    }

</script>

<style scoped>
.u-document-con{
    padding: 20px;
    background-color: #fff;
}
.u-title{
    border-bottom: 1px solid #EBEBEB;
    padding-bottom: 10px;
    position: relative;
}
.u-title .u-line{
    position: absolute;
    font-size: 16px;
    bottom: 0px;
    width: 300px;
    border-bottom: 3px solid #0193FF;
    left: 0px;
}
.ieKsWY{
    border-radius: 3px;
    padding: 10px 15px;
    background: rgb(217, 237, 247);
    border-width: 1px;
    border-style: solid;
    border-color: rgb(188, 232, 241);
    border-image: initial;
    margin: 30px 0px;
}
.u-describe{
    color: rgb(127, 133, 148);
    margin: 10px 0px 20px;
}
.u-tips{
    font-size: 16px;
    font-weight: 500;
    color: rgb(59, 69, 92);
    margin: 25px 0px 10px;
}
.u-orange{
    color: rgb(250, 170, 39);
}
.u-result{
    background-color: #FCFDFE;
    border: 1px solid #E7EDF4;
    padding: 10px;
    color: #282E32;
}
.u-result>div{
    line-height: 30px;
}
.u-result i{
    margin-right: 14px;
    color: #919CA4;
     font-style:normal
}
.u-FE5400{
    color:#FE5400;
    padding-left: 30px;
}
.u-padding30{
  padding-left: 30px;
}
.u-padding20{
  padding-left: 20px;
}
.u-B50000{
    color:#B50000;
    padding-left: 10px;
}
</style>