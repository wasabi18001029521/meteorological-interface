<template>
    <div>
        <nav-header/>
        <router-view></router-view>
        <nav-footer/>
    </div>
</template>

<script>
    import NavHeader from "./components/Header";
    import NavFooter from "./components/Footer";

    export default {
        components: {NavHeader, NavFooter},
    }
</script>
<style lang="less">
    body {
        margin: 0px;
        padding: 0px;
        /*background: url(assets/bg1.jpg) center !important;
            background-size: cover;*/
        // background: #1F2D3D;
        font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, SimSun, sans-serif;
        font-size: 14px;
        -webkit-font-smoothing: antialiased;
    }
    .u-size40{ font-size: 40px; }
    .u-size18{ font-size: 18px; }
    .u-size42{ font-size: 42px; }
    .u-size20{ font-size: 20px; }
    .u-size16{ font-size: 16px; }
    .u-line-height2{ line-height: 1em;}
    .u-line-height2{ line-height: 2em; }
    .u-line-height4{ line-height: 4em;}
    .el-main{ padding: 0px !important;}
</style>