package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.InterfaceReturnDataBase;
import cn.webyun.meteorologicalinterface.mapper.RefinedUrbanForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@Service
public class RefinedUrbanForecastService {
    @Autowired
    RefinedUrbanForecastMapper refinedUrbanForecastMapper;
    @Autowired
    UserKeyVaildService userKeyVaildService;

    /**
     *  输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国精细化城镇预报数据。
     * 通过密钥获取信息
     * 1.判断是否为空
     * 2.判断密钥是否有效---------调用密钥的方法，判断是否超出有效期，
     * 3.根据密钥以及信息查询数据
     * 4.判断时间是否填写，若未填写，显示为当前时间
     * @param interfaceParame
     * @return
     */
    public InterfaceReturnDataBase getCityAreainfo(InterfaceParame interfaceParame) throws TimeoutException {
       // InterfaceReturnDataBase data=  findByParame(interfaceParame);
        /*if(data==null){
           throw new
        }*/
        InterfaceReturnDataBase data=new InterfaceReturnDataBase();
        //传入userkey和可用时间做验证，返回boolean
        boolean flag= userKeyVaildService.volitUserKey(interfaceParame.getUserkey(),10);
        if(flag){
            //若返回的天数大于产品可使用天数，例如7，那么提示无权限，返回状态吗401
            throw new TimeoutException();
        }
            ArrayList arr = new ArrayList();
            arr.add("arr1");
            arr.add("barr2");
            if (data.getDatatime() == null) {
                data.setDatatime(new Date().toString());

            }
            data.setLonlat(arr);

            return data;
    }
    private InterfaceReturnDataBase findByParame(InterfaceParame interfaceParame){
        return refinedUrbanForecastMapper.findByParam(interfaceParame);
    }

    /**
     * 根据站点编号，查询时间区间内（闭区间）的中国精细化城镇预报数据。
     * @param interfaceParame
     * @return
     */
    public InterfaceReturnDataBase getCityOneinfo(InterfaceParame interfaceParame) {
        InterfaceReturnDataBase data=new InterfaceReturnDataBase();
        return data;
    }
}
