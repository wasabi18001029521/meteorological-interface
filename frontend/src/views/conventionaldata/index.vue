<template>
    <el-container>
        <el-main>
            <div class='u-banner-box data-banner'>
                <div class="u-banner">
                    <el-row class='u-size18 u-line-height2'>
                        <el-col :span="24">
                            <div class="grid-content bg-purple-dark">Weather Data</div>
                        </el-col>
                    </el-row>
                    <el-row class='u-size40 u-line-height2'>
                        <el-col :span="24">
                            <div class="grid-content bg-purple-dark">常规数据</div>
                        </el-col>
                    </el-row>
                    <el-row class='u-size20 u-line-height2'>
                        <el-col :span="24">
                            <div class="grid-content bg-purple-dark">通过API接口，为企业用户提供面向公众的常规天气数据，可轻松整合至手机</div>
                        </el-col>
                    </el-row>
                    <el-row class='u-size20 u-line-height2'>
                        <el-col :span="24">
                            <div class="grid-content bg-purple-dark">APP、网站或智能硬件，展示给C端用户。</div>
                        </el-col>
                    </el-row>
                    <el-row class='u-size16 u-line-height4'>
                        <el-col :span="24">
                            <div class="grid-content bg-purple-dark">
                                <el-button type="warning" @click='see'>查看 API 文档</el-button>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </div>
            <div class="u-data-box">
                <el-row class='u-size40 u-line-height3'>
                    <el-col :span="24">
                        <div class="grid-content bg-purple-dark">数据类型</div>
                    </el-col>
                </el-row>
                <el-row :gutter="20" class='u-data-list'>
                    <el-col :span="6" v-for="lists in dataType">
                        <el-card shadow="never" class="box-card">
                      <span class='u-card-decorate'>
                        <i v-if="lists.title=='天气'" class='icon iconfont icon-tianqi u-odd'></i>
                        <i v-if="lists.title=='空气质量'" class='icon iconfont icon-kongqiditu'></i>
                        <i v-if="lists.title=='生活'" class='icon iconfont icon-shenghuofuwu u-odd'></i>
                        <i v-if="lists.title=='地理'" class='icon iconfont icon-richurila'></i>
                      </span>
                            <div class='u-list-title data-text-item u-size16'>{{lists.title}}</div>
                            <div v-for="o in lists.item" class="text-item"> {{o}} </div>
                        </el-card>
                    </el-col>
                </el-row>
                <el-row class='u-data-api'>
                    <el-col :span="12" class='u-to-api'>
                        <p class='u-size20 u-line-height2 '>数据通过 API 接口调用</p>
                        <p class='u-size16 u-line-height2 '>通过标准 Restful API 协议访问海量天气和环境数据，</p>
                        <p class='u-size16 u-line-height2 '>高稳定性，随需随调。</p>
                        <el-button type="warning" @click='see'>查看 API 文档</el-button>
                    </el-col>
                </el-row>
            </div>
            <div class='u-data-box'>
                <el-row class='u-size40 u-line-height3'>
                    <el-col :span="24">
                        <div class="grid-content bg-purple-dark">服务质量</div>
                    </el-col>
                </el-row>
                <el-row :gutter="20" class='u-data-list'>
                    <el-col :span="8"  v-for="list in serviceData">
                        <el-card class="box-card">
                            <div v-if="list.title=='权威数据'" class='data-serve data-serve-1'></div>
                            <div v-if="list.title=='高并发支持'"  class='data-serve data-serve-2'></div>
                            <div v-if="list.title=='贴心服务'"  class='data-serve data-serve-3'></div>
                            <div class=' u-list-title u-size16'>{{list.title}}</div>
                            <div class="text-item">
                                {{ list.item }}
                            </div>
                        </el-card>
                    </el-col>
                </el-row>
            </div>
        </el-main>
    </el-container>
</template>

<script>

    export default {
        name: 'dataTab',
        components: {},
        data(){
            return{
                dataType:[{title:'天气',item:['天气实况','分钟级降水预报','15天逐日天气预报','24小时逐小时天气预报','逐3小时精细化天气预报','过去24小时历史天气','昨日天气']},
                	{title:'空气质量',item:['空气质量实况','空气质量实况城市安排','逐日空气质量预报','逐小时空气质量预报','过去24小时空气质量']},
                	{title:'生活',item:['生活指数','气象灾害预警','农历、节气、生肖','机动车尾号限行']},
                	{title:'地理',item:['潮汐预报','日出日落时间','月初月落时间']}],
                serviceData:[{title:'权威数据',item:'国内天气数据来自中国气象局相关机构，国际数据来自欧洲中长期预报中心和美国环境预报中心。'},
                	{title:'高并发支持',item:'分布式服务器集群，提供大客户独立服务器及宽带，通过负载均衡、缓存、CDN等技术、支持每日亿级访问量。'},
                	{title:'贴心服务',item:'拥有10年天气数据企业服务经验，提供完善的售前支出和售后服务体系，5x8小时专属客服。'}]

            }
        },
        methods: {
            see() {
                this.$router.push({path: '/api/documents'})
            },
        }
    }
</script>
<style lang="less">
    .data-banner {
        height: 604px;
        background: url('../../assets/img/data-banner.jpg');
    }

    .u-data-box {
        padding-top: 40px;
        text-align: center;
        background-color: #fbfbfb;

        .box-card {
            border: none;
        }
        .text-item{
            line-height: 24px;
            text-align: left;
            color: #9C9C9C;
        }
        .data-text-item{
            text-align: left;
        }
        .u-card-decorate {
            display: inline-block;
            position: absolute;
            top: -10px;
            margin-left: -48px;
            width: 100px;
            height: 50px;
            background-color: #fff;
            border-radius: 50px 50px 0 0;
            padding-top: 16px;

            i {
                font-size: 40px;
                color: #0C98FF;
            }

            .u-odd {
                color: #FF9601;
            }
        }

        .u-data-list {
            padding-top: 40px;
            padding-left: 100px;
            padding-right: 100px;
            padding-bottom: 70px;
            margin: 40px 0px 0px 0px !important;
            .box-card{
                min-height: 232px;
            }
            .data-serve {
                width: 70px;
                height: 70px;
                margin: auto;
                margin-bottom: 20px;
            }

            .data-serve-1 {
                background: url('../../assets/img/data-serve-1.png') no-repeat;
                background-size: 100%;
            }

            .data-serve-2 {
                background: url('../../assets/img/data-serve-2.png') no-repeat;
                background-size: 100%;
            }

            .data-serve-3 {
                background: url('../../assets/img/data-serve-3.png') no-repeat;
                background-size: 100%;
            }

            .u-list-title {
                font-weight: bold;
                margin-bottom: 10px;
            }
        }

        .u-data-api {
            background: url('../../assets/img/data-api.png') no-repeat;
            background-size: 100% 390px;
            height: 390px;

            .u-to-api {
                padding-right: 100px;
                text-align: right;
                color: #fff;
                margin-top: 84px;
                float: right;
            }
        }

    }
</style>
