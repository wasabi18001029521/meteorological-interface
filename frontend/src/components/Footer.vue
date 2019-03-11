<template>
     <el-container>
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
  name: 'NavFooter',
  components: {

  }
}
</script>
<style lang="less">
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
            font-size: 12px;
         }
    }
</style>