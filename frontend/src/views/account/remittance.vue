<template>
    <el-container>
        <el-main>
            <div class='u-remittance-box'>
                <div class="u-title u-size16">
                    <span>银行汇款</span>
                    <span class="u-line"></span>
                </div>
                <div class="u-remittance-con">
                    <el-row :gutter="20">
                      <el-col :span="12" class="u-step1">
                        <div class="u-size16">
                            <span  class="u-tip">1</span>
                            <span>第一步&nbsp;&nbsp;银行汇款</span>
                        </div>
                        <div class="u-con">
                            <div class="u-tips">开户银行</div>
                            <div class="u-details">招商银行北京青年路支行</div>
                            <div class="u-tips">收款账号</div>
                            <div class="u-details">1122 3456 7890 0088</div>
                            <div class="u-tips">收款人</div>
                            <div class="u-details">中国气象局天气接口服务</div>
                            <div class="u-tips">汇款金额</div>
                            <div class="u-details u-orange">￥12，00.00</div>
                            <div class="u-remarks-box">
                                请将<span class="u-orange">U8DDB776D8</span>填写到银行汇款备注中
                            </div>
                        </div>
                      </el-col>
                      <el-col :span="12">
                        <div class="u-size16">
                            <span class="u-tip">2</span>
                            <span>第一步&nbsp;&nbsp;联系我们，开通服务</span>
                        </div>
                        <div class="u-con">
                            <div class="u-remarks-box">
                                付款后，请尽快<span class="u-orange">通过一下方式联系售后，</span>为你开通服务
                            </div>
                            <div class="u-tips">企业QQ</div>
                            <div class="u-details">2423537765</div>
                            <div class="u-tips">联系电话</div>
                            <div class="u-details">400-900-8888</div>
                            <div class="u-tips">企业邮箱</div>
                            <div class="u-details">hi@seniserde.com</div>
                        </div>
                      </el-col>
                    </el-row>
                </div>
            </div>
        </el-main>
    </el-container>
</template>

<script>
export default {
    name: 'remittance',
    data(){
        return{

        }
    },
    methods:{

    }
}
</script>
<style lang="less">
.u-remittance-box{
    margin: 40px 100px;
    padding: 20px;
    background-color: #fff;
    .u-title{
        border-bottom: 1px solid #EBEBEB;
        padding-bottom: 10px;
        position: relative;
        .u-line{
            position: absolute;
            font-size: 16px;
            bottom: 0px;
            width: 66px;
            border-bottom: 3px solid #0193FF;
            left: 0px;
        }
    }
    .u-remittance-con{
        border: 1px solid  #EBEBEB;
        margin-top: 20px;
        padding:20px 10px;
        color: #424242;
        .u-tip{
            padding: 2px 4px;
            margin-right: 10px;
            background-color: #0092FF;
            color: #fff;
        }
        .u-step1{
             border-right: 1px solid  #EBEBEB;

        }
        .u-con{
            padding-left: 22px;
        }
        .u-tips{
            color: #BFBFBF;
            font-size: 12px;
            margin-bottom: 10px;
            margin-top: 20px;
        }
        .u-details{
            font-size: 16px;
            color: #474747;
            font-weight: 600;
        }
        .u-orange{
            color: #FEA322;
        }
        .u-remarks-box{
            width: 90%;
            border: 1px solid  #EBEBEB;
            background-color: #FFF4E6;
            padding: 20px 10px;
            font-size: 16px;
            color: #474747;
            margin-top: 20px;
        }
    }
}

</style>
