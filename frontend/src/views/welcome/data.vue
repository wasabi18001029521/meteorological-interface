<template>
    <div class="home">
        <el-main>
            <div class='u-banner-box'>
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
                    <el-card class="box-card">
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                  <el-col :span="6">
                    <el-card class="box-card">
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                  <el-col :span="6">
                    <el-card class="box-card">
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                  <el-col :span="6">
                    <el-card class="box-card">
                      <div class='u-list-title u-size16'>天气</div>
                      <div v-for="o in 6" :key="o" class="text item">
                        {{'列表内容 ' + o }}
                      </div>
                    </el-card>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="12">
                    <div>这里是图片就可以啦</div>
                  </el-col>
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
                    <el-col :span="6">
                        <el-card class="box-card">
                            <div class='u-list-title u-size16'>天气</div>
                            <div v-for="o in 6" :key="o" class="text item">
                                {{'列表内容 ' + o }}
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="6">
                        <el-card class="box-card">
                            <div class='u-list-title u-size16'>天气</div>
                            <div v-for="o in 6" :key="o" class="text item">
                                {{'列表内容 ' + o }}
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="6">
                        <el-card class="box-card">
                            <div class='u-list-title u-size16'>天气</div>
                            <div v-for="o in 6" :key="o" class="text item">
                            {{'列表内容 ' + o }}
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="6">
                        <el-card class="box-card">
                            <div class='u-list-title u-size16'>天气</div>
                            <div v-for="o in 6" :key="o" class="text item">
                                {{'列表内容 ' + o }}
                            </div>
                        </el-card>
                    </el-col>
                </el-row>
            </div>
        </el-main>
    </div>
</template>

<script>
 export default {
        name: 'dataTab',
        components: {},
    }
</script>
<style lang="less">
.u-data-box{
    padding-top: 40px;
    text-align: center;
    background-color: #fbfbfb;
    .u-data-list{
        padding-top: 40px;
        padding-left: 100px;
        padding-right: 100px;
        padding-bottom: 70px;
        margin: 0px !important;
        .u-list-title{
           font-weight: bold;
        }
    }
    .u-to-api{
        padding-right: 100px;
        text-align: right;
    }
}
</style>
