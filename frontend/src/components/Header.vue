<template>
    <el-container>
        <el-header>
            <el-row>
                <el-col :span="12" :xs="5"  :sm="8" >
                    <div class="grid-content bg-purple">中央气象台</div>
                </el-col>
                <el-col :span="12" :xs="19"  :sm="16" >
                    <div class="grid-content bg-purple-light">
                        <!--TODO  http://element-cn.eleme.io/#/zh-CN/component/menu -->
                        <el-row :gutter="10">
                            <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4" class='u-color9b'><span @click="toIndex">首页</span></el-col>
                            <el-col :xs="5" :sm="4" :md="4" :lg="4" :xl="4" class='u-color9b'>
                                <el-menu mode="horizontal" active-text-color="#ffd04b">
                                    <el-submenu index="1">
                                      <template slot="title">数据</template>
                                      <el-menu-item index="1-1" @click="addData">选项1</el-menu-item>
                                      <el-menu-item index="1-2">选项2</el-menu-item>
                                      <el-menu-item index="1-3">选项3</el-menu-item>
                                    </el-submenu>
                                </el-menu>
                            </el-col>
                            <el-col :xs="4" :sm="5" :md="5" :lg="5" :xl="5" class='u-color9b'><span>价格</span></el-col>
                            <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
                                <el-button type="primary">注册</el-button>
                            </el-col>
                            <el-col :xs="4" :sm="4" :md="4" :lg="4" :xl="4">
                                <el-button type="info">登录</el-button>
                            </el-col>
                        </el-row>
                    </div>
                </el-col>
            </el-row>
        </el-header>
    </el-container>
</template>

<script>
    export default {
        name: 'NavHeader',
        components: {},
        methods:{
            toIndex(){
            	this.$router.push('/');
            },
            addData() {
				this.$router.push('/dataTab');
			},
        }
    }
</script>
<style lang="less">
    .el-header {
        text-align: center;
        line-height: 60px;
        background-color: rgb(45, 50, 54);
        color: #fff;
        .active{
            border-bottom-color: rgb(255, 208, 75);
            color: rgb(255, 208, 75);
        }
        .u-color9b {
            color: #9b9b9b;
            span{
                display: inline-block;
                width: 100%;
                height: 100%;
                cursor: pointer;
            }
        }
        .el-menu.el-menu--horizontal{
            border: none;
        }
        .el-menu{
            background-color: rgb(45, 50, 54);
        }
        .el-submenu{
            width: 100%;
        }
        .is-opened{
            background-color:#fff;
        }
    }
</style>