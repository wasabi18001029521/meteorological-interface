<template>
    <el-container>
        <el-main>
        <el-row class="u-purchase-box">
          <el-col :span="16" class="u-purchase">
            <div>
                <div class="u-title u-size16">选择你需要要的数据<span class="u-line"></span></div>
                <el-row :gutter="20" class="u-con-box">
                  <el-col :span="6"><b>天气实况</b></el-col>
                  <el-col :span="3" class="u-select-box active"><div>选择</div></el-col>
                  <el-col :span="4"><div class="u-orange u-company"><i class="el-icon-question"></i>￥1500/月</div></el-col>
                </el-row>
                <el-row :gutter="20" class="u-con-box">
                  <el-col :span="6"><b>天气预报</b></el-col>
                  <el-col :span="16">
                    <ul>
                        <li class="active">不需要</li>
                        <li>5天</li>
                        <li>10天</li>
                        <li>15天</li>
                    </ul>
                  </el-col>
                </el-row>
            </div>
            <div>
                <div class="u-title u-size16">选择访问量额度<span class="u-line"></span></div>
                <el-row :gutter="20" class="u-con-box">
                  <el-col :span="6"><b>访问量额度</b></el-col>
                  <el-col :span="16">
                    <ul>
                        <li class="active">30万次/月</li>
                        <li>100万次/月</li>
                        <li>300万次/月</li>
                        <li>1000万次/月</li>
                        <li>5000万次/月</li>
                        <li><b>不限量</b></li>
                        <li class="u-orange">免费</li>
                    </ul>
                  </el-col>
                </el-row>
            </div>
            <div>
                <div class="u-title u-size16">选择服务时长<span class="u-line"></span></div>
                <el-row :gutter="20" class="u-con-box">
                  <el-col :span="6"><b>包月</b></el-col>
                  <el-col :span="16">
                    <ul>
                        <li class="active">1</li>
                        <li>2</li>
                        <li>3</li>
                        <li>4</li>
                        <li>5</li>
                        <li>6</li>
                        <li>7</li>
                        <li>8</li>
                        <li>9</li>
                    </ul>
                    <span class="u-company">个月</span>
                  </el-col>
                </el-row>
                <el-row :gutter="20" class="u-con-box">
                  <el-col :span="6"><b>包年</b></el-col>
                  <el-col :span="16">
                    <ul>
                        <li class="active">1</li>
                        <li>2</li>
                    </ul>
                    <span class="u-company">年（包年更优惠，买一年仅付10个月的钱）</span>
                  </el-col>
                </el-row>
            </div>
          </el-col>
          <el-col :span="5" class="u-selected">
            <div class="u-selected-title">已选择套餐 </div>
            <div class="u-selected-con">
                 <div class="u-title"><b>数据</b></div>
                 <el-row class="u-con-box">
                    <el-col :span="10">天气实况</el-col>
                    <el-col :span="12" class="u-right"><div>￥1500/月</div></el-col>
                </el-row>
                <div class="u-title"><b>访问量</b></div>
                <el-row class="u-con-box">
                    <el-col :span="16">访问量（100万次）</el-col>
                    <el-col :span="6" class="u-right"><div>免费</div></el-col>
                </el-row>
                <div class="u-title"><b>合计</b></div>
                    <el-row class="u-con-box">
                        <el-col :span="14">每月费用</el-col>
                        <el-col :span="8" class="u-right"><div>￥1500/月</div></el-col>
                    </el-row>
                    <div class="u-title"></div>
                    <el-row class="u-con-box">
                        <el-col :span="14">服务时常</el-col>
                        <el-col :span="8" class="u-right"><div>1个月</div></el-col>
                    </el-row>
                    <div class="u-title"></div>
                    <el-row class="u-con-box">
                        <el-col :span="14">总计</el-col>
                        <el-col :span="8" class="u-right"><b>￥1500/月</b></el-col>
                    </el-row>
                <el-row>
                  <el-button type="warning">提交订单</el-button>
                </el-row>
                </div>
            </div>
            </div>

          </el-col>
        </el-row>
        </el-main>
    </el-container>
</template>

<script>
 export default {
        name: 'purchase',
        components: {},
    }
</script>
<style lang="less">
.u-purchase-box{
    margin: 20px 100px;
    .u-purchase{
        padding: 10px 20px;
        background-color: #fff;
        .u-title{
            border-bottom: 1px solid #EBEBEB;
            padding-bottom: 10px;
            position: relative;
            .u-line{
                position: absolute;
                bottom: 0px;
                width: 150px;
                border-bottom: 3px solid #0193FF;
                left: 0px;
            }
        }
        .u-con-box{
            padding: 10px  0 0;
            .u-orange{
                color: #FF9600;
                .el-icon-question{
                    color: #DBDBDB;
                }
            }
            li,.u-select-box{
                float: left;
                padding: 2px 14px;
                line-height: 30px;
                text-align: center;
                border: 1px solid #E8E8E8;
                margin: 0 10px 10px 0;
                list-style: none;
                cursor: pointer;
            }
            li.u-orange{
                border: none;
            }
            .u-company{
                display: inline-block;
                margin-top: 8px;
            }
        }
    }
    .u-selected{
        margin-left: 20px;
        background-color: #fff;
        .u-selected-title{
           width: 100%;
            height: 40px;
            line-height: 40px;
            background-color: #0092FF;
            padding-left: 10px;
            color: #fff;
        }
        .u-selected-con{
            padding: 10px;
            .u-title{
                border-bottom: 1px solid #EBEBEB;
                b{
                    margin-bottom: 8px;
                    display: inline-block;
                }
            }
            .u-right{
                text-align: right;
            }
            .u-con-box{
                margin: 10px 0 14px;
            }
            .el-button{
                width: 100%;
            }
        }
    }
    .active{
         background: url('../../assets/img/triangle.png') no-repeat right bottom;
         border: 1px solid #0A96FC !important;
    }
}
</style>
