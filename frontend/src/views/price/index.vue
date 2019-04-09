<template>
    <el-container>
        <el-main>
            <el-row class='u-size40 u-api-title'>
              <el-col :span="24"><div class="grid-content bg-purple-dark">常规数据API价格</div></el-col>
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
            <el-row  :gutter="20" class='u-api-box'>
                <el-col :span="12">
                    <p class='u-con-title'>数据</p>
                    <div v-for="o in 6" :key="o" class="u-item">
                        {{'列表内容 ' + o }}
                    </div>
                </el-col>
                <el-col :span="12">
                    <p class='u-con-title'>数据</p>
                    <div v-for="o in 6" :key="o" class="u-item">
                        {{'列表内容 ' + o }}
                    </div>
                </el-col>
            </el-row>
             <el-row  :gutter="20" class='u-api-box'>
                <el-col :span="12">
                    <p class='u-con-title'>功能</p>
                    <div v-for="o in 6" :key="o" class="u-item">
                        {{'列表内容 ' + o }}
                    </div>
                </el-col>
                <el-col :span="12">
                    <p class='u-con-title'>功能</p>
                    <div v-for="o in 6" :key="o" class="u-item">
                        {{'列表内容 ' + o }}
                    </div>
                </el-col>
             </el-row>
             <el-row  :gutter="20" class='u-api-box'>
                <el-col :span="12">
                    <p class='u-con-title'>服务</p>
                    <div v-for="o in 4" :key="o" class="u-item">
                        {{'列表内容 ' + o }}
                    </div>
                </el-col>
                <el-col :span="12">
                    <p class='u-con-title'>服务</p>
                    <div v-for="o in 4" :key="o" class="u-item">
                        {{'列表内容 ' + o }}
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
            <el-row :gutter="20" class='u-card' >
                <el-col :span="8"  :offset="4">
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
        methods:{
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
.u-api-title{
    text-align: center;
    background-color: #242730;
    height: 100px;
    color: #fff;
    line-height: 100px;
    background: url('../../assets/img/api.png');
}
.u-api-type,
.u-api-box{
    padding: 0 100px;
    text-align: center;
    padding-bottom: 20px;
    margin: 0px !important;
    background-color: #fff;
    .u-con-title{
        background-color: #fbfbfb;
        font-weight: bold;
        height: 40px;
        line-height: 40px;
        font-size: 16px;
    }
    .u-item{
        border-bottom: 1px solid #e7e7e7;
        height: 40px;
        line-height: 40px;
        color: #989898;
    }
}
.u-api-type{
    padding-top: 20px;
    color: #fff;
    background: url('../../assets/img/api-type.png') no-repeat center;
    height: 296px;
}
.u-api-more{
    background-color: #0092ff;
    color: #fff;
    text-align: center;
    background: url('../../assets/img/api-more.png') no-repeat center;
}
.u-card{
    margin: 0px !important;
    padding-top: 40px;
    padding-bottom: 40px;
    background-color: #fbfbfb;
    .u-card-img{
        width: 80px;
        height: 80px;
        display: inline-block;
        float: left;
        margin-right: 20px;
        margin-top: 14px;
    }
    .u-card-text{
        margin-left: 100px;
        span{
            display: block;
        }
        button{
            margin-top: 10px;
        }
    }
}
</style>
