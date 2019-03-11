<template>
      <div>
        <nav-header/>
        <nav-footer/>
     </div>
</template>

<script>
import NavHeader from "./components/Header";
import NavFooter from "./components/Footer";

export default {
  components: { NavHeader,NavFooter},
}
</script>
<style lang="less">
body{
	margin: 0px;
	padding: 0px;
	/*background: url(assets/bg1.jpg) center !important;
		background-size: cover;*/
	// background: #1F2D3D;
	font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, SimSun, sans-serif;
	font-size: 14px;
	-webkit-font-smoothing: antialiased;
}
</style>