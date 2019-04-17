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
                        <div v-for="item in myOrder" class='u-order-box'>
                            <div  class='u-order-item'>
                                <el-card class="box-card">
                                    <div slot="header" class="clearfix" :class="item.state">
                                        <span class='u-state u-payment' v-if="item.state=='payment'">等待付款</span>
                                        <span class='u-state u-invalid' v-if="item.state=='invalid'">已失效</span>
                                        <span>订单号： {{item.id}}</span> <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><span>下单时间： {{item.time}}</span>
                                        <span style="float: right; padding: 3px 0" type="text">订单金额：<span class='u-size18'>{{item.price}}</span>元</span>
                                    </div>
                                    <div  style="position: relative;">
                                        <ul>
                                            <li v-for="i in item.details" class="text item" >{{ i }}</li>
                                        </ul>
                                        <el-button v-if="item.state=='payment'" class="u-operation-btn" type="warning" @click="toPayment">立即支付</el-button>
                                        <el-button v-if="item.state=='invalid'" disabled class="u-operation-btn" type="info" >已失效</el-button>
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
            <el-form status-icon :model="ruleForm2" ref="ruleForm2"  >
            <el-dialog title="修改密码" :visible.sync="dialogVisible" width="30%" >
              <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <el-form-item label="当前密码" prop="currentPassword">
                  <el-input type="text" v-model="ruleForm2.currentPassword" autocomplete="off"></el-input>
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
                  <el-button type="primary"  @click="confirm('ruleForm2')" >确 认</el-button>
              </span>
            </el-dialog>
            </el-form>
        </el-main>
    </el-container>
</template>

<script>
    // 导入chart组件
    import XChart from '../../components/chart.vue'
    // 导入chart组件模拟数据
    import options from '@/assets/js/chart-options/options'
    import {mapState,mapActions} from "vuex";
    import {getToken} from '@/utils/auth'
    import getters from '../../store/getters'
    import store from "../../store";
    export default {
        name: 'Message',
        data() {
            let option = options.bar
            var checkCurrentPassword = (rule, value, callback) => {
                    if (value === '') {
                         callback(new Error('当前密码不能为空'));
                    }if(value.length < 6){
                    callback(new Error('请输入6位以及6位以上的密码'));
                     }
                    else {
                        callback();
                    }
                  };
             var validatePass = (rule, value, callback) => {
                   if (value === '') {
                      callback(new Error('请输入密码'));
                    }if(value.length < 6){
                     callback(new Error('请输入6位以及6位以上的密码'));
                 }else if(this.ruleForm2.pass === this.ruleForm2.currentPassword){
                        callback(new Error('密码不能与当前密码相同'));
                    } else{
                      callback();
                      }
                  };
             var validatePass2 = (rule, value, callback) => {
                  if (value === '') {
                    callback(new Error('请再次输入密码'));
                    } if(value.length < 6){
                     callback(new Error('请输入6位以及6位以上的密码'));
                 }else if (value !== this.ruleForm2.pass) {
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
                    currentPassword: '',
                    pass: '',
                    checkPass: '',

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
                myOrder:[{id:'123234983248136241982091375',time:'2019-3-2 14:22:50',price:'1200',details:['中国全部和国家主要三千城市','日出日落时间'],state:'payment'},
                {id:'5555549832481362419855555',time:'2019-4-2 11:11:50',price:'500',details:['中国全部城市','天气实况'],state:'invalid'},]
            };
        },
        methods: {
            confirm(ruleForm2){
                this.$refs[ruleForm2].validate(valid => {
                    if (valid) {
                        this.$router.push({path: '/'})
                        this.$store
                            .dispatch("updatePassword",this.ruleForm2)
                            .then(() => {
                            })
                            .catch(() => {
                                this.loading = false;
                            });
                    } else {
                        return false;
                    }
                });
            },
            toPayment(){
                this.$router.push("/payment")
            }
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
            .u-operation-btn{
                position: absolute;
                right: 10px; top: 10px;
            }
        }
    }
</style>
