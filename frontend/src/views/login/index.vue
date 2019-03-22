<template>
    <el-main>
        <div class="login u-banner-box">
            <div class="form2" style="background: #fefff3">
                <div class="context1">
                    <h1 class="account" align="center">登录账号</h1>
                </div>
                <br/>
                <el-form :model="login_form" status-icon label-width="100px" ref="login_form"
                         class="demo-ruleForm">
                    <el-form-item label="邮箱 :" prop="login_email"
                                  :rules="[
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }]">
                        <el-input v-model="login_form.login_email" autocomplete="off"
                                  style="width:250px;height:0px" placeholder="注册邮箱"></el-input>
                    </el-form-item>
                    <el-form-item label="密码 :" prop="login_pass" :rules="[
                    {required: true, message: '请输入密码', trigger: 'blur'},
                    { min: 6, message: '6位以上字母和数字密码', trigger: 'blur' }
                    ]">
                        <el-input type="password" v-model="login_form.login_pass" autocomplete="off"
                                  style="width:250px;height:0px" placeholder="6位以上字母和数字密码"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('login_form')" class="sign">登 录</el-button>
                    </el-form-item>
                    <el-button type="text" @click="zh" class="retrieve">找回密码</el-button>
                    <el-button type="text" @click="zc" class="asd">注册新用户</el-button>
                </el-form>
            </div>
        </div>
    </el-main>
</template>
<script>
    export default {
        name: 'login',
        data() {
            return {
                login_form: {
                    login_email: '',
                    login_pass: '',
                }
            };
        },
        methods: {
            zc() {
                this.$router.push({path: '/api/register'})
            },
            zh() {
                this.$router.push({path: '/api/retrieve'})
            },
            submitForm(login_form) {

                this.$refs[login_form].validate(valid => {
                    if (valid) {
                        this.$store
                            .dispatch("Login", this.login_form)
                            .then(() => {
                                // this.loading = false;
                                this.$router.push({ path: "/" });
                            })
                            .catch(() => {
                                this.loading = false;
                            });
                        // console.log("success")
                    } else {
                        // console.log("error submit!!");
                        return false;
                    }
                });
            },

        }
    }
</script>
<style lang="less">
    .account {
        color: #ffebef;
        width: 150px;
        margin: 0 auto;
        font-size: 20px;
        width: 150px;
        height: 100px;
        text-align: center;
        line-height: 50px;

    }

    .context1 {
        background: #4585ff;
        width: 440px;
        height: 50px;
        background: url('../../assets/img/bg-login.png');
    }

    .form2 {
        margin: 0 auto;
        position: absolute;
        width: 440px;
        height: 300px;
        left: 50%;
        top: 35%;
        margin-left: -200px;
        margin-top: -100px;
        background-color: #fff !important
    }

    .retrieve {
        width: 250px;
        margin: 0 auto;
        height: 65px;
    }

    .sign {
        width: 300px;
        position: absolute;
        left: -50px;
        height: 40px;
    }
</style>
