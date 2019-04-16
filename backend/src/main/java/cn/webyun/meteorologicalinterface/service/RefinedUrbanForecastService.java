package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.ServiceException.DataException;
import cn.webyun.meteorologicalinterface.ServiceException.ParametersException;
import cn.webyun.meteorologicalinterface.ServiceException.PrivilegeException;
import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.InterfaceReturnData;
import cn.webyun.meteorologicalinterface.mapper.RefinedUrbanForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
     * 通过密钥获取信息
     * 1.判断是否为空
     * 2.判断密钥是否有效---------调用密钥的方法，判断是否超出有效期，
     * 3.根据密钥以及信息查询数据
     * 4.判断时间是否填写，若未填写，显示为当前时间
     *
     * @param interfaceParame
     * @return
     */
    public InterfaceReturnData getCityAreainfo(InterfaceParame interfaceParame)
            throws PrivilegeException, ParametersException {
        InterfaceReturnData data1 = new InterfaceReturnData();
        //传入userkey和可用时间做验证，返回剩余有效天数（暂时用不上）
        int date = userKeyVaildService.volitUserKey(interfaceParame.getKey(), 1);
        ArrayList arr = new ArrayList();
        arr.add("arr111111111111111");
        arr.add("barr22222222222222");
        if (data1.getDatatime() == null) {
            data1.setDatatime(new Date().toString());
        }
        data1.setLonlat(arr);
        return data1;

    }

    //通过私有方法调用持久层获取数据
    private InterfaceReturnData findByParame(InterfaceParame interfaceParame) {
        return refinedUrbanForecastMapper.findByParam(interfaceParame);
    }

    /**
     * 根据站点编号，查询时间区间内（闭区间）的中国精细化城镇预报数据。
     *
     * @param interfaceParame
     * @return
     */
    public InterfaceReturnData getCityOneinfo(InterfaceParame interfaceParame)
            throws DataException {
        InterfaceReturnData data1 = new InterfaceReturnData();
        //传入userkey和可用时间做验证，返回剩余有效天数（暂时用不上）
        int date = userKeyVaildService.volitUserKey(interfaceParame.getKey(), 1);
        ArrayList arr = new ArrayList();
        arr.add("arr111111111111111");
        arr.add("barr22222222222222");
        if (data1.getDatatime() == null) {
            data1.setDatatime(new Date().toString());
        }
        data1.setLonlat(arr);
        return data1;
    }
}
