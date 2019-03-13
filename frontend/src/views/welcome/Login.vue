<template>
    <div class="login">
        <el-main>
            <div class="form2" style="background: #fefff3">
                <div class="context1" >
                    <h1 class="zhanghao" align="center"  >登录账号</h1>
                </div>
                <br/>
                <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                    <el-form-item    label="邮箱 :" prop="pass">
                        <el-input type="username" v-model="ruleForm2.pass" autocomplete="off" style="width:250px;height:0px" placeholder="注册邮箱"></el-input>
                    </el-form-item>
                    <el-form-item label="密码 :" prop="checkPass">
                        <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off" style="width:250px;height:0px"  placeholder="6位以上字母和数字密码"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm2')" class="denglu">登   录</el-button>
                    </el-form-item>

                    <el-from-item>
                        <el-button type="text" class="zhaohuimima">找回密码</el-button>
                        <el-button type="text" >注册新用户</el-button>

                    </el-from-item>


                </el-form>
            </div>
        </el-main>

    </div>
</template>

<script>

    export default {
        name: 'login',

        data() {
            var checkAge = (rule, value, callback) => {};
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入邮箱'));
                } else {
                    if (this.ruleForm2.checkPass !== '') {
                        this.$refs.ruleForm2.validateField('checkPass');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else if (value.length<6) {
                    callback(new Error('用户名或密码错误，请重试'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm2: {
                    pass: '',
                    checkPass: '',
                    age: ''
                },
                rules2: {
                    pass: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],

                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },

        },


    }
</script>
<style lang="less">
    .zhanghao {
        color: #ffebef;
        width:150px;
        margin: 0 auto;
        font-size:20px;
        width:150px; height:100px; text-align:center; line-height:50px;
    }
    .context1 {
        background: #4585ff;
        width:440px;
        height: 50px;

    }
    .form2{


        margin: 0 auto;
        position: absolute;
        width:440px;
        height:300px;
        left:50%;
        top:35%;
        margin-left:-200px;
        margin-top:-100px
    }

    .zhaohuimima {
        width:250px;
        margin: 0 auto;
        height: 65px;
    }
    .denglu {
        width:300px;
        position:absolute;left:-50px;
        height: 40px;
    }



</style>