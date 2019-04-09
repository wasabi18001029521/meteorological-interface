<template>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="400px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1', '3']">
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-message"></i>API开发文档</template>
                    <el-submenu index="1-4">
                        <template slot="title">中国地面自动站</template>
                        <el-menu-item index="1-4-1" @click="autoarea">中国地面自动站区域查询数据获取接口</el-menu-item>
                        <el-menu-item index="1-4-2" @click="autoone">中国地面自动站单站查询数据获取接口</el-menu-item>
                        <el-menu-item index="1-4-3" @click="autonearest">中国地面自动站最近站数据获取接口</el-menu-item>
                    </el-submenu>
                    <el-submenu index="2-4">
                        <template slot="title">精细化城市预报</template>
                        <el-menu-item index="2-4-1" @click="cityarea">精细化城市预报矩形区域查询数据获取接口</el-menu-item>
                        <el-menu-item index="2-4-2" @click="cityone">精细化城市预报单站查询数据获取接口</el-menu-item>
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
        <el-col>
            <div v-if="loginType === 'autoarea'">
                <div>中国地面自动站区域查询数据获取接口</div>
                <div>----------------------------------------------------------</div>
                <div>GET /station/auto/area/</div>
                <br/>
                <div>根据输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国地面气象站逐小时观测数据，并提供分级抽希功能。</div>
                <br/>
                <div>请求地址试例</div>
                <div>矩形区域范围内,中国地面气象站逐小时观测数据  https://localhost:8080/station/auto/area?key=your_api_key&level=1&maxLon=22.22&maxLat=22.22
                    &minLon=22.22&minLat=22.22&var=[1,2]&datatime=2019-04-03 10:13:55&format=2019-04-09 02:01:58
                </div>
                <div>参数</div>
                <div>
                    <el-table
                            :data="tableDataautoarea"
                            style="width: 100%">
                        <el-table-column
                                prop="name"
                                label="参数名"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="type"
                                label="类型"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="must"
                                label="必须"
                                width="180">
                        </el-table-column>
                        <el-table-column
                                prop="remarks"
                                label="备注">
                        </el-table-column>
                    </el-table>
                </div>

            </div>
            <div v-if="loginType === 'autoone'">中国地面自动站单站查询数据获取接口</div>

            <div v-if="loginType === 'autonearest'">中国地面自动站最近站数据获取接口</div>

        <div v-if="loginType === 'cityarea'">
            　<div>精细化城市预报矩形区域查询数据获取接口</div>
                <div>----------------------------------------------------------</div>
                <div>GET localhost</div>
        </div>

            <div v-if="loginType === 'cityone'">精细化城市预报单站查询数据获取接口</div>
        </el-col>
    </el-container>
</template>

<script>
    export default {
        name: "autoarea",
       data(){
        return {
            loginType:'indexImg',
            tableDataautoarea: [{
                name: 'level',
                type: 'integer',
                must: '是',
                remarks:'抽稀级别 [1,2,3,4]'
            }, {
                name: 'maxLon',
                type: 'number',
                must: '是',
                remarks:'最大经度'
            }, {
                name: 'maxLat',
                type: 'number',
                must: '是',
                remarks:'最大纬度'
            }, {
                name: 'minLon',
                type: 'number',
                must: '是',
                remarks:'最小经度'
            }, {
                name: 'minLat',
                type: 'number',
                must: '是',
                remarks:'最小纬度'
            }, {
                name: 'var',
                type: 'array',
                must: '是',
                remarks:'查询的字段数组'
            }, {
                name: 'datatime',
                type: 'string',
                must: '是',
                remarks:'数据时间，格式 yyyyMMddHH，如果不传默认取最新的'
            }, {
                name: 'var',
                type: 'string',
                must: '否',
                remarks:'时间格式，默认yyyyMMddHHmmss'
            }]
       }
    },
        methods: {
            autoarea(){
                  this.loginType='autoarea'
            },
            autoone(){
                this.loginType='autoone'
            },
            autonearest(){
                this.loginType='autonearest'
            },
            cityarea(){
                this.loginType='cityarea'
            },
            cityone(){
                this.loginType='cityone'
            },


        },


    }

</script>

<style scoped>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>