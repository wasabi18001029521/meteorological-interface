<template>
    <el-container>
        <el-main>
            <div class='u-message-box'>
                <el-tabs :tab-position="tabPosition" style="height: 465px;">
                    <el-tab-pane label="账号信息" >
                        <div class='u-account-title'>账号信息<span class='u-line'></span></div>
                        <el-row class='u-account-item'>
                            <el-col :span="7" :offset="2"><div class="grid-content bg-purple">用户ID</div></el-col>
                            <el-col :span="15"><div class="grid-content bg-purple-light">{{userid}}</div></el-col>
                        </el-row>
                        <el-row class='u-account-item'>
                            <el-col :span="7" :offset="2"><div class="grid-content bg-purple">用户邮箱</div></el-col>
                            <el-col :span="15"><div class="grid-content bg-purple-light">{{myusername}}</div></el-col>
                        </el-row>
                        <el-row class='u-account-item'>
                            <el-col :span="7" :offset="2"><div class="grid-content bg-purple">注册时间</div></el-col>
                            <el-col :span="15"><div class="grid-content bg-purple-light">{{userregister}}</div></el-col>
                        </el-row>
                        <el-row class='u-account-item'>
                            <el-col :span="7" :offset="2"><div class="grid-content bg-purple">上次登录时间</div></el-col>
                            <el-col :span="15"><div class="grid-content bg-purple-light">{{userlogin}}</div></el-col>
                        </el-row>
                        <el-row class='u-account-item'>
                            <el-col :span="7" :offset="2"><div class="grid-content bg-purple">API密钥</div></el-col>
                            <el-col :span="15"><div class="grid-content bg-purple-light">{{userkey}}</div></el-col>
                        </el-row>
                        <el-row class='u-account-item'>
                            <el-col :span="15" :offset="9"><el-button type="primary" @click="dialogVisible = true" >修改密码</el-button></el-col>


                        </el-row>
                    </el-tab-pane>
                    <el-tab-pane label="我的订单">
                        <div class='u-account-title'>我的订单<span class='u-line'></span></div>
                        <div v-for="o in 2" :key="o" class='u-order-box'>
                            <div  class='u-order-item'>
                                <el-card class="box-card">
                                    <div slot="header" class="clearfix">
                                        <span class='u-state'>等待付款</span>
                                        <span>订单号： 123234983248136241982091375</span>
                                        <span style="float: right; padding: 3px 0" type="text">订单金额：<span class='u-size18'>1200</span>元</span>
                                    </div>
                                    <div  style="position: relative;">
                                        <div v-for="o in 3" :key="o" class="text item" >
                                            {{'列表内容 ' + o }}
                                        </div>
                                        <el-button style="position: absolute; right: 10px; top: 10px; " type="warning">操作按钮</el-button>
                                    </div>
                                </el-card>
                            </div>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="访问量统计">
                        <div class='u-account-title'>访问量统计<span class='u-line'></span></div>
                        <x-chart :id="id" :option="option"></x-chart>
                    </el-tab-pane>
                </el-tabs>
            </div>
            <el-dialog title="修改密码" :visible.sync="dialogVisible" width="30%" >
              <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <el-form-item label="当前密码" prop="currentPassword">
                  <el-input type="text" v-model.number="ruleForm2.currentPassword" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="新密码" prop="pass">
                  <el-input ttype="text" v-model="ruleForm2.pass" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="确认新密码" prop="checkPass">
                  <el-input type="text" v-model="ruleForm2.checkPass" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false">确 认</el-button>
              </span>
            </el-dialog>
        </el-main>
    </el-container>
</template>

<script>
    // 导入chart组件
    import XChart from '../../components/chart.vue'
    // 导入chart组件模拟数据
    import options from '../../chart-options/options'
    import {mapState,mapActions} from "vuex";
    import {getToken} from '@/utils/auth'
    import getters from '../../store/getters'
    import store from "../../store";
    export default {
        name: 'Message',
        data() {
            let option = options.bar
            var checkCurrentPassword = (rule, value, callback) => {
                    if (!value) {
                      return callback(new Error('当前密码不能为空'));
                    }
                    setTimeout(() => {
                      if (value) {
                        if (value < 18) {
                          callback(new Error('必须满18的数字'));
                        } else {
                          callback();
                        }
                      }
                    }, 1000);
                  };
             var validatePass = (rule, value, callback) => {
                    if (value === '') {
                      callback(new Error('请输入密码'));
                    }else if(value == this.ruleForm2.currentPassword){
                        callback(new Error('密码不能与当前密码相同'));
                    } else if (this.ruleForm2.checkPass !== '') {
                        this.$refs.ruleForm2.validateField('checkPass');
                      }
                      callback();
                  };
             var validatePass2 = (rule, value, callback) => {
                    if (value === '') {
                      callback(new Error('请再次输入密码'));
                    } else if (value !== this.ruleForm2.pass) {
                      callback(new Error('两次输入密码不一致!'));
                    } else {
                      callback();
                    }
                  };
            return {
                userid:store.getters.userid,
                myusername:store.getters.myname,
                userregister:store.getters.userregister,
                userlogin:store.getters.userlogin,
                userkey:store.getters.userkey,
                tabPosition: 'left',
                dialogVisible: false,
                // chart
                id: 'test',
                option: option,
                show:'false',
                 ruleForm2: {
                    pass: '',
                    checkPass: '',
                    currentPassword: ''
                 },
                 rules2: {
                   pass: [
                        { validator: validatePass, trigger: 'blur' }
                   ],
                   checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                   ],
                   currentPassword: [
                        { validator: checkCurrentPassword, trigger: 'blur' }
                   ]
                 },
            };
        },
      /*  created() {
            //console.log("页面未渲染之前就发送请求 ")
            /!*      this.$store
                      .dispatch("my")
                      .then(() => {
                      })
                      .catch(() => {
                      })*!/
            this.fetchData()
            console.log("页面显示的ID="+store.getters.userid)
            console.log()
            /!*   console.log(123)
               console.log(store.getters.userid)*!/
        },
        watch: {
            // 如果路由有变化，会再次执行该方法
            '$route': 'fetchData'
        },*/
        methods: {
      /*      fetchData(){
                this.$store
                    .dispatch("my")
                    .then(() => {
                    })
                    .catch(() => {
                    })
            },
*/
            open1() {

                this.$axios.post('http://localhost:8080/passworddo/password', {
                    username: '956901244@qq.com',
                    password: this.password,
                    newpassword:this.Newpassword,
                    confirmthenewpassword:this.Confirmthenewpassword

                })
                    .then(successResponse => {
                        this.responseResult = JSON.stringify(successResponse.data)
                        if (successResponse.data.code === 200) {
                            this.$message({
                                message: successResponse.data.message,
                                type: 'success'
                            });
                        }if (successResponse.data.code !== 200) {
                            //  alert(JSON.stringify(successResponse.data.message))
                            this.$message({
                                message: successResponse.data.message,
                                type: 'warning'
                            });
                        }}).catch(failResponse => {})
            },
        },
        components: {
            XChart
        }
    }
</script>
<style lang="less">
    .el-main{
        background-color: #fbfbfb;
        .u-message-box{
            margin: 40px 100px;
            .u-account-title{
                height: 24px;
                border-bottom: 1px solid #ddd;
                margin-bottom: 20px;
                .u-line{
                    display: block;
                    width: 57px;
                    margin-top: 4px;
                    border-bottom: 2px solid #409EFF;
                }
            }
            .el-tabs__header.is-left{
                margin-right: 40px;
            }
            .el-tabs__nav-wrap.is-left{
                background-color: #fff;
                width: 200px;
                [role=tab]{
                    border-bottom: 1px solid #ddd;
                }
            }
            .el-tabs--left .el-tabs__item.is-left{
                text-align:left;
            }
            [role=tabpanel] {
                background-color: #fff;
                padding: 16px;
                height: 465px;
                .u-account-item{
                    height: 40px;
                    line-height: 40px;
                }
            }
            .el-tabs__nav-wrap::after{
                background-color: #fff;
            }
            .u-order-box{
                padding: 10px 20px;
                .u-state{
                    display: block;
                }
            }
        }
    }
</style>
