package cn.webyun.meteorologicalinterface.controller;


import cn.webyun.meteorologicalinterface.ServiceException.ParametersException;
import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.InterfaceReturnData;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.service.RefinedUrbanForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/station/city")
/*
精细化城市预报
继承BaseController处理异常
 */
public class RefinedUrbanForecastController extends BaseController{
    @Autowired
    RefinedUrbanForecastService refinedUrbanForecastService;

    /**
     * 输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国精细化城镇预报数据。
     * @param interfaceParame
     * @return
     */
    @GetMapping("/area")
    public ResponseEntity<?> CityArea(@Valid  InterfaceParame interfaceParame) {

        if(refinedUrbanForecastService.VolitParames(interfaceParame)){
            throw new ParametersException("参数异常");
        };


        InterfaceReturnData interfaceReturnDataBase = refinedUrbanForecastService.getCityAreainfo(interfaceParame);
            return ResponseEntity.ok(new ResponseBase(interfaceReturnDataBase));
    };
    /**
     * 根据站点编号，查询时间区间内（闭区间）的中国精细化城镇预报数据。
     * @param interfaceParame
     * @return
     */
    @GetMapping("/one")
    public ResponseEntity<?> CityOne(@Valid  InterfaceParame interfaceParame) {
       /*  System.out.println(interfaceParame.getSid()+"+"+interfaceParame.getElems()
                +"+"+interfaceParame.getBasetime()+"+"+interfaceParame.getStart()+"+"+interfaceParame.getEnd());*/
        if(refinedUrbanForecastService.VolitParames(interfaceParame)){
            throw new ParametersException("参数异常");
        };
            InterfaceReturnData interfaceReturnDataBase = refinedUrbanForecastService.getCityOneinfo(interfaceParame);
            return ResponseEntity.ok(new ResponseBase(interfaceReturnDataBase));
    }
}
