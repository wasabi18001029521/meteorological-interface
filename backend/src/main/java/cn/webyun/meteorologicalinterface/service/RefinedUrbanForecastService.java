package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.InterfaceReturnData;
import cn.webyun.meteorologicalinterface.mapper.RefinedUrbanForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class RefinedUrbanForecastService {
    @Autowired
    RefinedUrbanForecastMapper refinedUrbanForecastMapper;
    /**
     * 通过密钥获取信息
     * 1.判断是否为空
     * 2.判断密钥是否有效
     * 3.根据密钥以及信息查询数据
     * 4.判断时间是否填写，若未填写，显示为当前时间
     * @param interfaceParame
     * @return
     */
    public InterfaceReturnData getinfo(InterfaceParame interfaceParame){
       // InterfaceReturnData data=  findByParame(interfaceParame);
        InterfaceReturnData data=new InterfaceReturnData();

            ArrayList arr=new ArrayList();
            arr.add("arr1");
            arr.add("barr2");
            if(data.getDatatime()==null) {
                data.setDatatime(new Date().toString());
                data.setBasetime("setBasetime");
            }
            data.setLonlat(arr);
            return data;
    }
    private InterfaceReturnData findByParame(InterfaceParame interfaceParame){
        return refinedUrbanForecastMapper.findByParam(interfaceParame);
    }
}
