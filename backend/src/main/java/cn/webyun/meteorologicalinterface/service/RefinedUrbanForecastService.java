package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.ServiceException.DataException;
import cn.webyun.meteorologicalinterface.ServiceException.ParametersException;
import cn.webyun.meteorologicalinterface.ServiceException.PrivilegeException;
import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.InterfaceReturnData;
import cn.webyun.meteorologicalinterface.mapper.RefinedUrbanForecastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@Service
public class RefinedUrbanForecastService {
    @Resource
    RefinedUrbanForecastMapper refinedUrbanForecastMapper;
    @Autowired
    UserKeyVaildService userKeyVaildService;
    @Resource
    UserService userService;

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
    InterfaceReturnData data1 = new InterfaceReturnData();

    public InterfaceReturnData getCityAreainfo(InterfaceParame interfaceParame)
            throws PrivilegeException, ParametersException {
        //判断参数异常的方法

        //传入userkey和可用时间做验证，返回剩余有效天数（暂时用不上）
        int date = userKeyVaildService.volitUserKey(interfaceParame.getKey(), 1);
        ArrayList var = new ArrayList();
        var.add(150.26);
        var.add(12.46);

        data1.setBasetime(interfaceParame.getBasetime());
        if (data1.getDatatime() == null) {
            data1.setDatatime(userService.dataTime());
        }
        data1.setLcc(2.2);
        data1.setLonlat(var);
        data1.setP(1300.0);
        data1.setPrec(20.5);
        data1.setRh(18.0);
        data1.setStaCode("8站点");
        data1.setT(9.2);
        data1.setTcc(493.6);
        data1.setVis(71.6);
        data1.setWd(83.6);
        data1.setWp("天气现象编码1");
        data1.setWs(5.0);
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
        //传入userkey和可用时间做验证，返回剩余有效天数（暂时用不上）
        int date = userKeyVaildService.volitUserKey(interfaceParame.getKey(), 1);
        ArrayList var = new ArrayList();
        var.add(168.25);
        var.add(56.89);
        data1.setBasetime(interfaceParame.getBasetime());
        if (data1.getDatatime() == null) {
            data1.setDatatime(userService.dataTime());
        }
        data1.setLcc(7.6);
        data1.setLonlat(var);
        data1.setP(1100.0);
        data1.setPrec(17.8);
        data1.setRh(15.6);
        data1.setStaCode("7站点");
        data1.setT(8.5);
        data1.setTcc(521.6);
        data1.setVis(92.5);
        data1.setWd(78.6);
        data1.setWp("天气现象编码1");
        data1.setWs(7.0);
        return data1;
    }

    public boolean VolitParames(InterfaceParame interfaceParame) {
        //  System.out.println("VolitParames");

        if (interfaceParame.getSid() == null) {
            //说明走的是1.2.11　精细化城市预报矩形区域查询数据获取接口
            if (interfaceParame.getMaxLon() == null || interfaceParame.getMaxLat() == null ||
                    interfaceParame.getMinLat() == null || interfaceParame.getMinLon() == null ||
                    interfaceParame.getVar() == null) {
                //  System.out.println("interfaceParame.getSid()==null+VolitParames");
                return false;
            }

        }
        if (interfaceParame.getElems() == null || interfaceParame.getStart() == null
                || interfaceParame.getEnd() == null) {
            return false;
        }
        return false;
    }

    ;
}
