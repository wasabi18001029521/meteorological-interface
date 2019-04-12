<template>
    <el-container>
        <el-main>
            <div class='u-payment-box'>
                <div class="u-title u-size16">
                    <span>付款</span>
                    <span class="u-line"></span>
                </div>
                <div class="u-payment-con">
                    <div class="u-tips u-size16">订单详情</div>
                    <ul v-for="item in details">
                        <li>{{item }}</li>
                    </ul>
                </div>
                <div class="u-money-box">
                    <div class="u-tips u-size16">订单金额</div>
                    <el-row>
                        <el-col :span="16">
                            <el-row class="u-tips">
                                <el-col :span="6"><span>单价</span></el-col>
                                <el-col :span="6"><span>数量</span></el-col>
                                <el-col :span="6"><span>优惠</span></el-col>
                                <el-col :span="6"><span>应付</span></el-col>
                            </el-row>
                            <el-row v-for="item in money">
                                <el-col :span="3" class="u-size18"><span>￥{{item.money}}</span></el-col>
                                <el-col :span="3" class="u-top4"><span>x</span></el-col>
                                <el-col :span="3" class="u-size18"><span>{{item.num}}个月</span></el-col>
                                <el-col :span="3" class="u-top4"><span>-</span></el-col>
                                <el-col :span="3" class="u-size18"><span>￥{{item.discount}}</span></el-col>
                                <el-col :span="3" class="u-top4"><span>=</span></el-col>
                                <el-col :span="3" class="u-size18 u-orange"><span>￥{{item.payment}}</span></el-col>
                            </el-row>
                        </el-col>
                        <el-col :span="6">
                            <el-col :span="12">
                                <el-button type="warning">支付宝付款</el-button>
                            </el-col>
                            <el-col :span="12">
                                <el-button type="info" @click="toRemittance">银行汇款</el-button>
                            </el-col>
                        </el-col>
                    </el-row>
                </div>
            </div>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: 'payment',
        data() {
            return {
                details: ["中国全部和国际3千主要城市", "日出日落时间", "月出月落时间和月相", "使用时常：1个月", "访问量限额：100万/个月", "新够套餐"],
                money: [{money: "12,00", num: "1", discount: "0", payment: "12,00"}]
            }
        },
        methods: {
            toRemittance() {
                this.$router.push("/remittance")
            }
        }
    }
</script>
<style lang="less">
    .u-payment-box {
        margin: 40px 100px;
        padding: 20px;
        background-color: #fff;

        .u-title {
            border-bottom: 1px solid #EBEBEB;
            padding-bottom: 10px;
            position: relative;

            .u-line {
                position: absolute;
                font-size: 16px;
                bottom: 0px;
                width: 36px;
                border-bottom: 3px solid #0193FF;
                left: 0px;
            }
        }

        .u-payment-con {
            border: 1px solid #EBEBEB;
            margin-top: 20px;
            padding: 20px 10px;
            color: #424242;

            ul {
                padding-left: 18px;

                li {
                    line-height: 24px;
                    height: 24px;
                }
            }
        }

        .u-money-box {
            border: 1px solid #EBEBEB;
            border-top: none;
            background-color: #FFF4E6;
            padding: 20px 10px;
            color: #666666;
        }

        .u-tips {
            padding-bottom: 10px;
        }

        .u-orange {
            color: #FEA322;
        }

        .u-top4 {
            padding-top: 4px;
        }
    }

</style>
