<template>
    <el-container>
        <el-main>
            <div class='u-banner-box u-index-banner'>
                <div class="u-banner">
                    <el-row class="u-size40 u-line-height2">
                      <el-col :span="24"><div class="grid-content bg-purple-dark">权威天气数据  极速稳定接入</div></el-col>
                    </el-row>
                    <el-row class="u-size18 u-line-height2">
                      <el-col :span="24"><div class="grid-content bg-purple-dark">已准确稳定服务次数</div></el-col>
                    </el-row>
                    <el-row class='u-size42 u-line-height2'>
                      <el-col :span="24"><div class="grid-content bg-purple-dark">5821639</div></el-col>
                    </el-row>
                    <el-row class='u-size16 u-line-height2'>
                      <el-col :span="24"><div class="grid-content bg-purple-dark"><el-button type="warning" >立即免费使用</el-button></div></el-col>
                    </el-row>
                </div>
            </div>
        </el-main>
    </el-container>
</template>

<script>

    export default {
        name: 'welcome',
    }
</script>
<style lang="less">
.u-banner-box{
    height: 542px;
    position: relative;
    background-color:#fbfbfb;
    color: #fff;
    .u-banner{
        text-align: center;
        height: 280px;
        width: 680px;
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -140px;
        margin-left: -340px;
        }
}
.u-index-banner{
    height: 90%;
    width: 100%;
    position: absolute;
    background: url('../../assets/img/banner.jpg');
}
</style>
