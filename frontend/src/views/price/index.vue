<template>
    <el-container>
        <el-main>
            <el-row class='u-size40 u-api-title'>
                <el-col :span="24">
                    <div class="grid-content bg-purple-dark">常规数据API价格</div>
                </el-col>
            </el-row>
            <el-row :gutter="20" class='u-api-type'>
                <el-col :span="12">
                    <p class='u-size20 u-line-height2 '>个人免费版</p>
                    <p class='u-size16 u-line-height2 '>通过标准 Restful API 协议访问海量天气和环境数据，</p>
                    <p class='u-size16 u-line-height2 '>高稳定性，随需随调。</p>
                    <el-button type="primary"><span @click="toRegister">立即注册</span></el-button>
                </el-col>
                <el-col :span="12" class='u-to-api'>
                    <p class='u-size20 u-line-height2 '>企业付费版</p>
                    <p class='u-size16 u-line-height2 '>通过标准 Restful API 协议访问海量天气和环境数据，</p>
                    <p class='u-size16 u-line-height2 '>高稳定性，随需随调。</p>
                    <el-button type="warning"><span @click="toPurchase">报价 / 购买</span></el-button>
                </el-col>
            </el-row>
            <el-row :gutter="20" class='u-api-box'>
                <el-col :span="12">
                    <p class='u-con-title'>数据</p>
                    <div v-for="item in dataRecord1"class="u-item">
                        {{item }}
                    </div>
                </el-col>
                <el-col :span="12">
                    <p class='u-con-title'>数据</p>
                    <div v-for="item in dataRecord2" class="u-item">
                        {{ item }}
                    </div>
                </el-col>
            </el-row>
            <el-row :gutter="20" class='u-api-box'>
                <el-col :span="12">
                    <p class='u-con-title'>功能</p>
                    <div v-for="item in dataFunction1" class="u-item">
                        {{ item }}
                    </div>
                </el-col>
                <el-col :span="12">
                    <p class='u-con-title'>功能</p>
                    <div v-for="item in dataFunction2" class="u-item">
                        {{item}}
                    </div>
                </el-col>
            </el-row>
            <el-row :gutter="20" class='u-api-box'>
                <el-col :span="12">
                    <p class='u-con-title'>服务</p>
                    <div v-for="item in dataService1" class="u-item">
                        {{ item }}
                    </div>
                </el-col>
                <el-col :span="12">
                    <p class='u-con-title'>服务</p>
                    <div v-for="item in dataService2" class="u-item">
                        {{ item }}
                    </div>
                </el-col>
            </el-row>
            <el-row class='u-api-more'>
                <el-col :span="24">
                    <p class='u-size16 u-line-height2 '>更多定制服务</p>
                    <p>除了数据套餐和可定制购买的数据外，心知天气还可以为您提供更多定制化的数据和服务。</p>
                    <p>您也可以投票参与制定我们的开发计划。如有进一步需要，请联系我们。</p>
                </el-col>
            </el-row>
            <el-row :gutter="20" class='u-card'>
                <el-col :span="8" :offset="4">
                    <el-card shadow="hover">
                      <span class='u-card-img'>
                        <img src='../../assets/img/price-left.png'>
                      </span>
                        <div class='u-card-text'>
                            <span class='u-size18 u-line-height2'>付费版免费试用</span>
                            <span class='u-line-height1'>10000次访问量，可测试全部付费API接口</span>
                            <el-button type="primary">开始使用</el-button>
                        </div>
                    </el-card>
                </el-col>
                <el-col :span="8">
                    <el-card shadow="hover">
                        <span class='u-card-img'>
                            <img src='../../assets/img/price-right.png'>
                        </span>
                        <div class='u-card-text'>
                            <span class='u-size18 u-line-height2'>付费版免费试用</span>
                            <span class='u-line-height1'>10000次访问量，可测试全部付费API接口</span>
                            <el-button type="info">退款说明</el-button>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: 'price',
        components: {},
        data(){
            return{
            dataRecord1:['国内369个地级市','天气实况（2项）','3天天气预报','生活指数（基础6项）','国内空气质量实况','国内空气质量预报',
            '国内空气质量城市排行','实时气温监测','降水量检测','昨日天气','气象灾害预警','未来24小时逐时天气预报','过去24小时历史天气',
            '过去24小时历史空气质量','农历、节气、生肖','机动车尾号限行'],
            dataRecord2:['多达全球2.4万城市','天气实况（12项） ','多达15天天气预报','生活指数（全部27项）','国内空气质量实况','国内空气质量逐时和逐日预报','国内空气质量城市排行',
            '实时气温监测','降水量检测','昨日天气','气象灾害预警 ','未来24小时逐时天气预报','过去24小时历史天气','过去24小时历史空气质量','农历、节气、生肖','机动车尾号限行  '],
            dataFunction1:['13种语言支持：简繁英日法德西葡','泰俄印度印尼阿拉伯','自动定位：经纬度、IP地址等','城市搜索','批量查询'],
            dataFunction2:['13种语言支持：简繁英日法德西葡','泰俄印度印尼阿拉伯','自动定位：经纬度、IP地址等','城市搜索','批量查询'],
            dataService1:['访问量限额：400次/小时','服务器与带宽：共享','服务开通方式：自助','技术支持','发票与合同','API定制开发'],
            dataService2:['访问量限额：多至不限量','服务器与带宽：共享或独享','服务开通方式：自助或人工','技术支持：网络或电话','发票与合同','API定制开发'],
            }
        },
        methods: {
            toPurchase() {
                this.$router.push('/purchase');
            },
            toRegister() {
                this.$router.push({path: '/api/register'});
            },
        }
    }
</script>
<style lang="less">
    .u-api-title {
        text-align: center;
        background-color: #242730;
        height: 100px;
        color: #fff;
        line-height: 100px;
        background: url('../../assets/img/api.png');
    }

    .u-api-type,
    .u-api-box {
        padding: 0 100px;
        text-align: center;
        padding-bottom: 20px;
        margin: 0px !important;
        background-color: #fff;

        .u-con-title {
            background-color: #fbfbfb;
            font-weight: bold;
            height: 40px;
            line-height: 40px;
            font-size: 16px;
        }

        .u-item {
            border-bottom: 1px solid #e7e7e7;
            height: 40px;
            line-height: 40px;
            color: #989898;
        }
    }

    .u-api-type {
        padding-top: 20px;
        color: #fff;
        background: url('../../assets/img/api-type.png') no-repeat center;
        height: 296px;
    }

    .u-api-more {
        background-color: #0092ff;
        color: #fff;
        text-align: center;
        background: url('../../assets/img/api-more.png') no-repeat center;
    }

    .u-card {
        margin: 0px !important;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #fbfbfb;

        .u-card-img {
            width: 80px;
            height: 80px;
            display: inline-block;
            float: left;
            margin-right: 20px;
            margin-top: 14px;
        }

        .u-card-text {
            margin-left: 100px;

            span {
                display: block;
            }

            button {
                margin-top: 10px;
            }
        }
    }
</style>
