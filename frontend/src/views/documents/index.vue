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
                    <el-button type="primary" size="mini" class="u-size">GET</el-button>
                    <span  v-if="apiType === 'autoArea'"> /station/auto/area</span>
                    <span  v-if="apiType === 'autoOne'"> /station/auto/one</span>
                    <span  v-if="apiType === 'autoNearest'"> /station/auto/nearest</span>
                    <span  v-if="apiType === 'cityArea'"> /station/city/area</span>
                    <span  v-if="apiType === 'cityOne'"> /station/city/one</span>
                </div>
                <div class="u-describe"  v-if="apiType === 'autoArea'">根据输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国地面气象站逐小时观测数据，并提供分级抽希功能。</div>
                <div class="u-describe"  v-if="apiType === 'autoOne'">根据站点编号，查询时间区间内（闭区间）的中国地面气象站逐小时观测数据。</div>
                <div class="u-describe"  v-if="apiType === 'autoNearest'">根据输入的经纬度坐标，查找最近的站点在指定时间区间内的中国自动站观测数据。</div>
                <div class="u-describe"  v-if="apiType === 'cityArea'">根据输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国精细化城镇预报数据。</div>
                <div class="u-describe"  v-if="apiType === 'cityOne'">根据站点编号，查询时间区间内（闭区间）的中国精细化城镇预报数据。</div>
                <div class="u-tips">请求地址示例</div>
                <div class="u-describe"  v-if="apiType === 'autoArea'">矩形区域范围内,中国地面气象站逐小时观测数据
                    <span class="u-orange">http://localhost:8081/station/auto/area?key=your_api_key&level=1&maxLon=22.22&maxLat=22.22&minLon=22.22&minLat=22.22&var=1,2
                        &datatime=2019-04-03%2010:13:55&format=2019-04-09%2002:01:58</span></div>

                <div class="u-describe"  v-if="apiType === 'autoOne'">中国地面气象站逐小时观测数据
                    <span class="u-orange">http://localhost:8081/station/auto/one?key=your_api_key&sid=2&elems=1,2&start=2019-04-10%2012:04:48&end=2019-04-10%2012:04:48</span></div>

                <div class="u-describe" v-if="apiType === 'autoNearest'">指定时间区间内的中国自动站观测数据。
                    <span class="u-orange">http://localhost:8081/station/auto/nearest?key=your_api_key&lon=31.21&lat=22.12&start=2019-04-10%2012:04:48&end=2019-04-10%2012:05:36&elems=1,2</span></div>

                <div class="u-describe" v-if="apiType === 'cityArea'">查找区域内全部的站点在某一时刻的中国精细化城镇预报数据
                    <span class="u-orange">http://localhost:8081/station/city/area?key=your_api_key&maxLon=22.22&maxLat=33.33&minLon=11.11&minLat2.22&var=1,2&basetime=2019-04-10%2012:05:36&datatime=2019-04-10%2012:05:36&format=2019-04-10%2012:05:36</span></div>

                <div class="u-describe"  v-if="apiType === 'cityOne'">查询时间区间内（闭区间）的中国精细化城镇预报数据
                    <span class="u-orange">http://localhost:8081/station/city/one?key=your_api_key&sid=2&elems=1,2&basetime=2019-04-10%2012:05:36&start=2019-04-10 12:05:36&end=2019-04-10 12:05:36</span></div>
                <div class="u-tips">参数</div>
                <el-table :data="tableData" :header-cell-style="{background:'#eef1f6',color:'#606266'}" style="width: 100%">
                    <el-table-column prop="name" label="参数名" align="center" width="200"></el-table-column>
                    <el-table-column prop="type" label="类型" align="center" width="100"></el-table-column>
                    <el-table-column prop="must" label="必须" align="center" width="100"></el-table-column>
                    <el-table-column prop="remarks" label="说明" align="center"></el-table-column>
                </el-table>
                <div class="u-tips">返回结果</div>
                <div class="u-result">
                    <code-mirror :resultData="resultData"></code-mirror>
                </div>

            </div>
        </el-col>
        </el-row>
     </el-main>
    </el-container>
</template>

<script>
    import CodeMirror from '../../components/codemirror'
    import apiData from '@/assets/js/api-data/api-data'
    export default {
       name: "autoarea",
       components: {CodeMirror},
       data(){
        return {
            apiType:'autoArea',
            tableData:apiData.tableData("autoArea"),
            resultData:apiData.Result("autoArea")
       }
    },
        methods: {
            changeAPI(type){
                if(type == "autoArea"){
                    this.apiType='autoArea'
                }else if(type == "autoOne"){
                    this.apiType='autoOne'
                }else if(type == "autoNearest"){
                    this.apiType='autoNearest'
                }else if(type == "cityArea"){
                    this.apiType='cityArea'
                }else if(type == "cityOne"){
                    this.apiType='cityOne'
                }
                this.tableData = apiData.tableData(type)
                this.resultData = apiData.Result(type)
            },

    }}

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
    color: #282E32;
}
.u-result>div{
    line-height: 30px;
}
</style>