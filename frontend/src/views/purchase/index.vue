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
                        <li :class="{active: active=='none'}" @click="choice('none',$event)">不需要</li>
                        <li :class="{active: active=='fiveDay'}" @click="choice('fiveDay',$event)">5天</li>
                        <li :class="{active: active=='tenDay'}" @click="choice('tenDay',$event)">10天</li>
                        <li :class="{active: active=='fifteenDay'}" @click="choice('fifteenDay',$event)">15天</li>
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
                        <li :class="{activeQuota: activeQuota=='thirty'}" @click="choiceQuota('thirty',$event)">30万次/月</li>
                        <li :class="{activeQuota: activeQuota=='oneHundred'}" @click="choiceQuota('oneHundred',$event)">100万次/月</li>
                        <li :class="{activeQuota: activeQuota=='threeHundred'}" @click="choiceQuota('threeHundred',$event)">300万次/月</li>
                        <li :class="{activeQuota: activeQuota=='oneThousand'}" @click="choiceQuota('oneThousand',$event)">1000万次/月</li>
                        <li :class="{activeQuota: activeQuota=='fiveThousand'}" @click="choiceQuota('fiveThousand',$event)">5000万次/月</li>
                        <li  :class="{activeQuota: activeQuota=='unlimited'}" @click="choiceQuota('unlimited',$event)">不限量</li>
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
                        <li :class="{activeOften: activeOften=='one'}" @click="choiceOften('one',$event)">1</li>
                        <li :class="{activeOften: activeOften=='two'}" @click="choiceOften('two',$event)">2</li>
                        <li :class="{activeOften: activeOften=='three'}" @click="choiceOften('three',$event)">3</li>
                        <li :class="{activeOften: activeOften=='four'}" @click="choiceOften('four',$event)">4</li>
                        <li :class="{activeOften: activeOften=='five'}" @click="choiceOften('five',$event)">5</li>
                        <li :class="{activeOften: activeOften=='six'}" @click="choiceOften('six',$event)">6</li>
                        <li :class="{activeOften: activeOften=='seven'}" @click="choiceOften('seven',$event)">7</li>
                        <li :class="{activeOften: activeOften=='eight'}" @click="choiceOften('eight',$event)">8</li>
                        <li :class="{activeOften: activeOften=='nine'}" @click="choiceOften('nine',$event)">9</li>
                    </ul>
                    <span class="u-company">个月</span>
                  </el-col>
                </el-row>
                <el-row :gutter="20" class="u-con-box">
                  <el-col :span="6"><b>包年</b></el-col>
                  <el-col :span="16">
                    <ul>
                        <li :class="{activeOften: activeOften=='oneYear'}" @click="choiceOften('oneYear',$event)">1</li>
                        <li :class="{activeOften: activeOften=='twoYear'}" @click="choiceOften('twoYear',$event)">2</li>
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
                <el-row class="u-con-box">
                    <el-col :span="10">天气预报</el-col>
                    <el-col :span="12" class="u-right"><div>{{prediction}}</div></el-col>
                </el-row>
                <div class="u-title"><b>访问量</b></div>
                <el-row class="u-con-box">
                    <el-col :span="18">访问量（<span>{{visit}}</span>）</el-col>
                    <el-col :span="4" class="u-right"><div>免费</div></el-col>
                </el-row>
                <div class="u-title"><b>合计</b></div>
                    <el-row class="u-con-box">
                        <el-col :span="14">每月费用</el-col>
                        <el-col :span="8" class="u-right"><div>￥1500/月</div></el-col>
                    </el-row>
                    <div class="u-title"></div>
                    <el-row class="u-con-box">
                        <el-col :span="14">服务时常</el-col>
                        <el-col :span="8" class="u-right"><div>{{often}}</div></el-col>
                    </el-row>
                    <div class="u-title"></div>
                    <el-row class="u-con-box">
                        <el-col :span="14">总计</el-col>
                        <el-col :span="8" class="u-right u-size16"><b>￥ {{totalPrice}}</b></el-col>
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
    data(){
        return{
            active:'none',
            activeQuota:'thirty',
            activeOften:'one',
            visit:'30万次/月',
            prediction:'不需要',
            often:"1个月",
            totalPrice:"1500"
        }
    },
    methods:{
        choice(className,e){
            this.active = className;
            this.prediction = e.target.innerHTML;
        },
        choiceQuota(className,e){
            this.activeQuota = className;
            this.visit = e.target.innerHTML;
        },
        choiceOften(className,e){
            this.activeOften = className;
            if(className.indexOf("Year") == -1){
                this.often = e.target.innerHTML + "个月";
            }else{
                this.often = e.target.innerHTML + "年";
            }
        },
    }
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
    .active,.activeQuota,.activeOften{
         background: url('../../assets/img/triangle.png') no-repeat right bottom;
         border: 1px solid #0A96FC !important;
    }
}
</style>
