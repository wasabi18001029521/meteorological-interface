<template>
    <el-container>
        <el-header>
           <el-row>
             <el-col :span="12">
                <div class="grid-content bg-purple">中央气象台</div>
             </el-col>
             <el-col :span="12">
                 <div class="grid-content bg-purple-light">
                    <el-row :gutter="10">
                      <el-col :xs="8" :sm="6" :md="4" :lg="4" :xl="1" class='u-color9b'>首页</el-col>
                      <el-col :xs="4" :sm="6" :md="8" :lg="4" :xl="11" class='u-color9b'>数据<i class="el-icon-caret-bottom"></i></el-col>
                      <el-col :xs="4" :sm="6" :md="8" :lg="5" :xl="11" class='u-color9b'>价格</el-col>
                      <el-col :xs="8" :sm="6" :md="4" :lg="4" :xl="1"><el-button type="primary">注册</el-button></el-col>
                      <el-col :xs="8" :sm="6" :md="4" :lg="4" :xl="1"><el-button type="info">登录</el-button></el-col>
                    </el-row>
                 </div>
             </el-col>
           </el-row>
        </el-header>
        <el-main>main</el-main>
        <el-footer>
            <el-row :gutter="20">
              <el-col :span="6"><div class="grid-content bg-purple u-footer-logo">中央气象台</div></el-col>
              <el-col :span="16"><div class="grid-content bg-purple u-footer-text">Copyright  2005-2018 QiXiang.COM All rights reserved. 京ICP证060517号/京ICP备09080754号 京公网安备11010802020576号</div></el-col>
            </el-row>
        </el-footer>
    </el-container>
</template>

<script>
import{Container,Header,Main,Footer} from 'element-ui'
export default {
  name: 'index',
  components: {

  }
}
</script>
<style lang="less">
    .el-header{
        text-align: center;
        line-height: 60px;
        background-color: rgb(45,50,54);
        color: #fff;
        .u-color9b{
            color: #9b9b9b;
        }
    }
    .el-footer {
        position: absolute;
        bottom: 0;
        width: 100%;
        text-align: center;
        height: 83px !important;
        line-height: 83px;
        background-color: rgb(45,50,54);
        color: #9b9b9b;
        .u-footer-logo{
            text-align: right;
        }
        .u-footer-text{
            font-size: 14px;
         }
    }
    .el-main {
        text-align: center;
        line-height: 160px;
    }
</style>