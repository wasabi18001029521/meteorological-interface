<template>
<el-main>
    <div class="register u-banner-box">
           <div class="form1" style="background: #f3f7ec">
            <div class="context" >
                <h1 class="u-banner-text" align="center"  >注册账号</h1>
            </div>
            <br/>
            <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                <el-form-item    label="邮箱" prop="pass">
                    <el-input type="username" v-model="ruleForm2.pass" autocomplete="off" style="width:250px;height:0px" placeholder="您的工作邮箱" ></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="checkPass">
                    <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off" style="width:250px;height:0px"  placeholder="6位以上字母和数字密码" ></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="text" class="u-banner-xieyi" @click="service"><<中国气象台服务协议>></el-button>

                    <br/>
                    <el-button type="primary" @click="submitForm('ruleForm2')" class="u-banner-zhuce" >同意以上注册协议并注册</el-button>
                </el-form-item>
            </el-form>
           </div>
    </div>
</el-main>
</template>

<script>

    export default {
        name: 'register',

        data() {
            var checkAge = (rule, value, callback) => {};
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入邮箱'));
                } if(this.ruleForm2.checkPass !== ''){
                    var reg=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                    if(!reg.test(value)){
                        callback(new Error('请输入有效的邮箱'));
                    }
                }else {
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
                    callback(new Error('请输入6位以上字母和密码'));
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
            service(){
                this.$router.push({path: '/api/service'})
            },
            submitForm(){
                console.log(this.ruleForm2.pass)

                this.$axios.post('http://localhost:8080/weather/register', {
                     username: this.ruleForm2.pass,
                      password: this.ruleForm2.checkPass

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
            }
        },



    }
</script>
<style lang="less">
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
    .u-banner-xieyi{
        width:250px;
        margin: 0 auto;
    }
    .u-banner-zhuce{
        width:350px;
        position:absolute;left:-55px;
    }

</style>