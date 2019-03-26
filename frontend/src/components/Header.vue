<template>
    <el-container>
        <el-header>
            <el-row>
                <el-col :span="12" :xs="5" :sm="8">
                    <div class="grid-content bg-purple"><span class='u-logo'></span>中央气象台</div>
                </el-col>
                <el-col :span="12" :xs="19" :sm="16">
                    <div class="grid-content bg-purple-light">
                        <!--TODO  http://element-cn.eleme.io/#/zh-CN/component/menu -->
                        <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal"
                                 background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
                            <el-menu-item index="1" @click="toIndex">首页</el-menu-item>
                            <el-submenu index="2">
                                <template slot="title">数据</template>
                                <el-menu-item index="2-1" @click="addData">常规数据</el-menu-item>
                                <!--<el-menu-item index="2-2">选项2</el-menu-item>-->
                                <!--<el-menu-item index="2-3">选项3</el-menu-item>-->
                            </el-submenu>
                            <el-menu-item index="3" @click='toPrice'>价格</el-menu-item>
                            <el-menu-item index="4" v-if="!isAuthenticated">
                                <el-button type="primary" @click="register">注册</el-button>
                            </el-menu-item>
                            <el-menu-item index="5" v-if="!isAuthenticated" >
                                <el-button type="info" @click="deng">登录</el-button>
                            </el-menu-item>
                            <el-menu-item v-if="isAuthenticated" index="4" @click='myMessage'>我的账号</el-menu-item>
                            <el-menu-item index="5">
                                <el-button type="info" v-if="isAuthenticated">退出</el-button>
                            </el-menu-item>

                        </el-menu>
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
        computed: {
            isAuthenticated() {
                return this.$store.state.user.authenticated;
            }
        },
        data() {
            return {
                activeIndex: '1',
                activeIndex2: '1'
            }
        },
        methods: {
            toIndex() {
                this.$router.push('/');
            },
            addData() {
                this.$router.push('/dataTab');
            },
            toPrice() {
                this.$router.push('/price');
            },
            register() {
                this.$router.push({path: '/api/register'})
            },
            deng() {
                this.$router.push({path: '/api/login'})
            },
            myMessage() {

                this.$router.push({path: '/myMessage'})


            },


        },
    }


</script>
<style lang="less">
    .el-header {
        text-align: center;
        line-height: 60px;
        background-color: #545c64;
        color: #fff;

        li {
            width: 15%;
        }

        .el-menu.el-menu--horizontal {
            border-bottom: none;
        }

        .u-logo {
            width: 40px;
            height: 40px;
            display: inline-block;
            background: url('../assets/img/logo.png');
            vertical-align: middle;
            margin-right: 20px;
        }
    }
</style>
