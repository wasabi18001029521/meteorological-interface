<template>
<el-main>
    <div class="register u-banner-box">
           <div class="form1" style="background: #f3f7ec">
            <div class="context" >
                <h1 class="u-banner-text" align="center"  >注册账号</h1>
            </div>
            <br/>
            <el-form :model="register_from" status-icon ref="register_from" label-width="100px" class="demo-ruleForm">
                <el-form-item label="邮箱" prop="register_email" :rules="[
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }]">
                    <el-input type="username" v-model="register_from.register_email" autocomplete="off" style="width:250px;height:0px" placeholder="您的工作邮箱" ></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="register_pass" :rules="[
                    {required: true, message: '请输入密码', trigger: 'blur'},
                    { min: 6, message: '6位以上字母和数字密码', trigger: 'blur' }
                    ]">
                    <el-input type="password" v-model="register_from.register_pass" autocomplete="off" style="width:250px;height:0px"  placeholder="6位以上字母和数字密码" ></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="text" class="u-banner-treaty" @click="service"><<中国气象台服务协议>></el-button>
                    <br/>
                    <el-button type="primary" @click="submitForm('register_from')" class="u-banner-logon" >同意以上注册协议并注册</el-button>
                </el-form-item>
            </el-form>
           </div>
    </div>
</el-main>
</template>

<script>


    export default {
        name: 'userregister',
        data() {
            return {
                register_from: {
                    register_email: '',
                    register_pass: '',
                }
            };
        },

        methods: {
            service(){
                this.$router.push({path: '/api/service'})
            },
            submitForm(register_from){
                this.$refs[register_from].validate(valid => {
                    if (valid) {
                        this.$router.push({path: '/api/login'})
                        this.$store
                            .dispatch("register", this.register_from)
                            .then(() => {

                            })
                            .catch(() => {
                                this.loading = false;
                            });
                        // console.log("success")
                    } else {
                        // console.log("error submit!!");
                        return false;
                    }
                })
            },

        }


    }
</script>
<style lang="less">
    .register.u-banner-box{
        height: 90%;
        width: 100%;
        position: absolute;
    }
    .u-banner-text {
        color: #ffffff;
        width:150px;
        margin: 0 auto;
        font-size:20px;
        width:150px; height:100px; text-align:center; line-height:50px;
        }
    .context {
        background: #4396ff;
        width:440px;
        height: 50px;
        background: url('../../assets/img/bg-login.png');
    }
    .form1{
        margin: 0 auto;
        position: absolute;
        width:440px;
        height:300px;
        left:50%;
        top:35%;
        margin-left:-200px;
        margin-top:-100px;
        background-color: #fff !important;
    }
    .u-banner-treaty{
        width:250px;
        margin: 0 auto;
    }
    .u-banner-logon{
        width:350px;
        position:absolute;left:-55px;
    }

</style>