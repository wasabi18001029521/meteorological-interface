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
            <div v-if="loginType === 'autoarea'">中国地面自动站区域查询数据获取接口</div>
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
        name: "documents",
       data(){
        return {
            loginType:'indexImg',
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