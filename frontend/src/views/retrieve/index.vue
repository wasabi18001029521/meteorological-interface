<template>
    <el-main>
        <div class="login u-banner-box">
            <div class="form3" style="background: #fefff3">
                <div class="context2" >
                    <h1 class="account1" align="center"  >找回密码</h1>
                </div>
                <br/>
                <el-form >
                <div class="u-serve-text" >
                    请输入你的注册邮箱，我们会给您发送新的密码。
                </div>
                <br/>
                    <el-form-item>
                    <el-input placeholder="注册邮箱" v-model="input10" class="registered"  style="width:335px;"dclearable></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" class="refer" @click="open">提交</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </el-main>
</template>

<script>
    export default {
        name: "retrieve",
        methods: {
            open() {
                this.$alert('新密码已发送到注册邮箱，请使用新密码登录并尽快修改。', {
                    confirmButtonText: '确定',

                });
            }
        },

            data() {
                return {
                    input10: '',

                }
                var validatePass = (rule, value, callback) => {
                    if (value === '') {
                        callback(new Error('请输入邮箱'));
                    }  if(this.input10 !== ''){
                            var reg=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                            if(!reg.test(value)){
                                callback(new Error('请输入有效的邮箱'));
                            }
                    } else {
                        if (this.input10 !== '') {
                            this.$refs.ruleForm3.validateField('checkPass');
                        }
                        callback();
                    }
                };
                return {
                    ruleForm3: {
                        pass: '',
                        checkPass: '',
                        age: ''
                    },
                    rules3: {
                        pass: [
                            { validator: validatePass, trigger: 'blur' }
                        ],
                        checkPass: [
                            { validator: validatePass2, trigger: 'blur' }
                        ],
                    }
                };
            }

    }
</script>

<style lang="less">
    .account1 {
        color: #ffffff;
        width:150px;
        margin: 0 auto;
        font-size:20px;
        width:150px; height:100px; text-align:center; line-height:50px;
    }
    .context2 {
        background: #4585ff;
        width:440px;
        height: 50px;
    }
    .form3 {
        margin: 0 auto;
        position: absolute;
        width: 440px;
        height: 300px;
        left: 50%;
        top: 35%;
        margin-left: -200px;
        margin-top: -100px
    }
    .refer {
        width: 340px;
        position: absolute;
        left: 30px;
        height: 40px;

    }
    .registered{
        width:300px;
        position: absolute;
        left: 35px;
        height: 45px;
        width:20%;
    }
    .u-serve-text{
        width:400px;
        positon: absolute;
        left: -40px;
        text-align: center;


    }

</style>