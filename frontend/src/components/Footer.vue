<template>
    <el-container>
        <el-footer>
            <el-row :gutter="20">
                <el-col :span="6">
                    <div class="grid-content bg-purple u-footer-logo"><span class='u-logo'></span>中央气象台</div>
                </el-col>
                <el-col :span="16">
                    <div class="grid-content bg-purple u-footer-text">Copyright 2005-2018 QiXiang.COM All rights
                        reserved. 京ICP证060517号/京ICP备09080754号 京公网安备11010802020576号
                    </div>
                </el-col>
            </el-row>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name: 'NavFooter',
        components: {}
    }
</script>
<style lang="less">
    .el-footer {
        text-align: center;
         background-color: #2d3236;
         color: #9b9b9b;
         width: 100%;
         height: auto !important;
         line-height: 35px;
         padding-top: 20px !important;
         padding-bottom: 20px !important;
         position:absolute;
         bottom: 0px;
        .u-footer-logo {
            text-align: right;
        }

        .u-footer-text {
            font-size: 12px;
        }
        .u-logo{
            width: 40px;
            height: 40px;
            display: inline-block;
            background: url('../assets/img/logo.png');
            vertical-align: middle;
            margin-right: 20px;
        }
    }
</style>