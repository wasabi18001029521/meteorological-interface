<template>
    <el-container>
        <el-main>
            <div class='u-message-box'>
                <el-tabs :tab-position="tabPosition" style="height: 465px;">
                    <el-tab-pane label="账号信息">
                        <div class='u-account-title'>账号信息<span class='u-line'></span></div>
                         <el-row class='u-account-item'>
                           <el-col :span="7" :offset="2"><div class="grid-content bg-purple">用户ID</div></el-col>
                           <el-col :span="15"><div class="grid-content bg-purple-light">1122112211</div></el-col>
                         </el-row>
                         <el-row class='u-account-item'>
                           <el-col :span="7" :offset="2"><div class="grid-content bg-purple">用户邮箱</div></el-col>
                           <el-col :span="15"><div class="grid-content bg-purple-light">112211221122@qq.com</div></el-col>
                         </el-row>
                         <el-row class='u-account-item'>
                           <el-col :span="7" :offset="2"><div class="grid-content bg-purple">注册时间</div></el-col>
                           <el-col :span="15"><div class="grid-content bg-purple-light">2018-12-19 14:22:39</div></el-col>
                         </el-row>
                         <el-row class='u-account-item'>
                           <el-col :span="7" :offset="2"><div class="grid-content bg-purple">上次登录时间</div></el-col>
                           <el-col :span="15"><div class="grid-content bg-purple-light">2018-12-19 14:22:39</div></el-col>
                         </el-row>
                         <el-row class='u-account-item'>
                           <el-col :span="7" :offset="2"><div class="grid-content bg-purple">API密钥</div></el-col>
                           <el-col :span="15"><div class="grid-content bg-purple-light">sdk39kehldfdd</div></el-col>
                         </el-row>
                         <el-row class='u-account-item'>
                           <el-col :span="15" :offset="9"><el-button type="primary"  >修改密码</el-button></el-col>
                         </el-row>
                    </el-tab-pane>
                    <el-tab-pane label="我的订单">
                        <div class='u-account-title'>我的订单<span class='u-line'></span></div>
                        <div v-for="o in 2" :key="o" class='u-order-box'>
                            <div  class='u-order-item'>
                                <el-card class="box-card">
                                  <div slot="header" class="clearfix">
                                    <span class='u-state'>等待付款</span>
                                    <span>订单号： 123234983248136241982091375</span>
                                    <span style="float: right; padding: 3px 0" type="text">订单金额：<span class='u-size18'>1200</span>元</span>
                                  </div>
                                  <div  style="position: relative;">
                                    <div v-for="o in 3" :key="o" class="text item" >
                                        {{'列表内容 ' + o }}
                                    </div>
                                    <el-button style="position: absolute; right: 10px; top: 10px; " type="warning">操作按钮</el-button>
                                  </div>
                                </el-card>
                            </div>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="访问量统计">
                        <div class='u-account-title'>访问量统计<span class='u-line'></span></div>
                    </el-tab-pane>
                </el-tabs>
             </div>
        </el-main>
    </el-container>
</template>

<script>

    export default {
        name: 'myMessage',
        data() {
              return {
                tabPosition: 'left'
              };
            },
      }
</script>
<style lang="less">
.el-main{
    background-color: #fbfbfb;
    .u-message-box{
        margin: 40px 100px;
        .u-account-title{
            height: 24px;
            border-bottom: 1px solid #ddd;
            margin-bottom: 20px;
            .u-line{
                 display: block;
                 width: 57px;
                 margin-top: 4px;
                 border-bottom: 2px solid #409EFF;
            }
        }
        .el-tabs__header.is-left{
                margin-right: 40px;
        }
        .el-tabs__nav-wrap.is-left{
            background-color: #fff;
            width: 200px;
            [role=tab]{
                border-bottom: 1px solid #ddd;
            }
        }
        .el-tabs--left .el-tabs__item.is-left{
            text-align:left;
        }
        [role=tabpanel] {
            background-color: #fff;
            padding: 16px;
            height: 465px;
            .u-account-item{
                height: 40px;
                line-height: 40px;
            }
        }
        .el-tabs__nav-wrap::after{
            background-color: #fff;
        }
        .u-order-box{
            padding: 10px 20px;
            .u-state{
                display: block;
            }
        }
    }
}
</style>
