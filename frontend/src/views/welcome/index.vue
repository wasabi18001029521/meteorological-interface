<template>
    <div class="home">
        <el-main>
            <div class='u-banner-box'>
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
                      <el-col :span="24"><div class="grid-content bg-purple-dark"><el-button type="warning">立即免费使用</el-button></div></el-col>
                    </el-row>
                </div>
            </div>
        </el-main>
    </div>
</template>

<script>

    export default {
        name: 'welcome'
    }
</script>
<style lang="less">
.u-banner-box{
    height: 519px;
    position: relative;
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

</style>
