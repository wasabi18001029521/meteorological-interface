<template>
    <el-container>
        <el-main>
            <div class='u-banner-box data-banner'>
                <div class="u-banner">
                    <el-row class='u-size18 u-line-height2'>
                        <el-col :span="24"><div class="grid-content bg-purple-dark">Weather Data</div></el-col>
                    </el-row>
                    <el-row class='u-size40 u-line-height2'>
                        <el-col :span="24"><div class="grid-content bg-purple-dark">常规数据</div></el-col>
                    </el-row>
                    <el-row class='u-size20 u-line-height2'>
                        <el-col :span="24"><div class="grid-content bg-purple-dark">通过API接口，为企业用户提供面向公众的常规天气数据，可轻松整合至手机</div></el-col>
                    </el-row>
                     <el-row class='u-size20 u-line-height2'>
                        <el-col :span="24"><div class="grid-content bg-purple-dark">APP、网站或智能硬件，展示给C端用户。</div></el-col>
                     </el-row>
                    <el-row class='u-size16 u-line-height4'>
                        <el-col :span="24"><div class="grid-content bg-purple-dark"><el-button type="warning">查看 API 文档</el-button></div></el-col>
                    </el-row>
                </div>
            </div>
            <div  class="u-data-box">
                <el-row class='u-size40 u-line-height3'>
                  <el-col :span="24"><div class="grid-content bg-purple-dark">数据类型</div></el-col>
                </el-row>
                <el-row :gutter="20" class='u-data-list'>
                  <el-col :span="6">
                    <el-card shadow="never" class="box-card">
                      <span class='u-card-decorate'>
                        <i class='icon iconfont icon-tianqi u-odd'></i>
                      </span>
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                  <el-col :span="6">
                    <el-card shadow="never" class="box-card">
                      <span class='u-card-decorate'>
                        <i class='icon iconfont icon-kongqiditu'></i>
                      </span>
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                  <el-col :span="6">
                    <el-card shadow="never" class="box-card">
                      <span class='u-card-decorate'>
                        <i class='icon iconfont icon-shenghuofuwu u-odd'></i>
                      </span>
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                  <el-col :span="6">
                    <el-card shadow="never" class="box-card">
                      <span class='u-card-decorate'>
                        <i class='icon iconfont icon-richurila'></i>
                      </span>
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                </el-row>
                <el-row class='u-data-api'>
                  <el-col :span="12" class='u-to-api'>
                     <p class='u-size20 u-line-height2 '>数据通过 API 接口调用</p>
                     <p class='u-size16 u-line-height2 '>通过标准 Restful API 协议访问海量天气和环境数据，</p>
                     <p class='u-size16 u-line-height2 '>高稳定性，随需随调。</p>
                     <el-button type="warning">查看 API 文档</el-button>
                  </el-col>
                </el-row>
            </div>
            <div class='u-data-box'>
                <el-row class='u-size40 u-line-height3'>
                    <el-col :span="24"><div class="grid-content bg-purple-dark">服务质量</div></el-col>
                </el-row>
                <el-row :gutter="20" class='u-data-list'>
                    <el-col :span="8">
                        <el-card class="box-card">
                            <div class='data-serve data-serve-1'></div>
                            <div class=' u-list-title u-size16'>天气</div>
                            <div v-for="o in 3" :key="o" class="text item">
                                {{'列表内容 ' + o }}
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="8">
                        <el-card class="box-card">
                            <div class='data-serve data-serve-2'></div>
                            <div class='u-list-title u-size16'>天气</div>
                            <div v-for="o in 3" :key="o" class="text item">
                                {{'列表内容 ' + o }}
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="8">
                        <el-card class="box-card">
                            <div class='data-serve data-serve-3'></div>
                            <div class='u-list-title u-size16'>天气</div>
                            <div v-for="o in 3" :key="o" class="text item">
                            {{'列表内容 ' + o }}
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
    }
</script>
<style lang="less">
.data-banner{
    height: 604px;
    background: url('../../assets/img/data-banner.jpg');
}
.u-data-box{
    padding-top: 40px;
    text-align: center;
    background-color: #fbfbfb;
    .box-card{
        border: none;
    }
    .u-card-decorate{
        display: inline-block;
        position: absolute;
        top: -10px;
        margin-left: -48px;
        width: 100px;
        height: 50px;
        background-color: #fff;
        border-radius: 50px 50px 0 0;
        padding-top: 16px;
        i{
            font-size: 40px;
            color: #0C98FF;
        }
        .u-odd{
            color: #FF9601;
        }
    }
    .u-data-list{
        padding-top: 40px;
        padding-left: 100px;
        padding-right: 100px;
        padding-bottom: 70px;
        margin: 40px 0px 0px 0px !important;
        .data-serve{
            width: 70px;
            height: 70px;
            margin: auto;
            margin-bottom: 20px;
        }
        .data-serve-1{
            background: url('../../assets/img/data-serve-1.png') no-repeat;
            background-size: 100%;
        }
        .data-serve-2{
            background: url('../../assets/img/data-serve-2.png') no-repeat;
            background-size: 100%;
        }
        .data-serve-3{
            background: url('../../assets/img/data-serve-3.png') no-repeat;
            background-size: 100%;
        }
        .u-list-title{
           font-weight: bold;
        }
    }
    .u-data-api{
            background: url('../../assets/img/data-api.png') no-repeat;
            background-size: 100% 390px;
            height: 390px;
        .u-to-api{
            padding-right: 100px;
            text-align: right;
            color: #fff;
            margin-top: 84px;
            float: right;
        }
    }

}
</style>
