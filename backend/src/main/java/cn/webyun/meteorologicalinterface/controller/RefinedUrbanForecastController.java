package cn.webyun.meteorologicalinterface.controller;


import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.service.RefinedUrbanForecastService;
import cn.webyun.meteorologicalinterface.sysresult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/station/city")
/*
精细化城市预报
 */
public class RefinedUrbanForecastController {
    @Autowired
    RefinedUrbanForecastService refinedUrbanForecastService;

    /**
     * 输入的矩形区域范围，查找区域内全部的站点在某一时刻的中国精细化城镇预报数据。
     * @param interfaceParame
     * @return
     */
    @GetMapping("/area")
    public ResponseEntity<?> CityArea(@Valid InterfaceParame interfaceParame) {
       return ResponseEntity.ok(new ResponseBase(true,"成功",refinedUrbanForecastService.getinfo(interfaceParame).toString()));

    };

    /**
     * 根据站点编号，查询时间区间内（闭区间）的中国精细化城镇预报数据。
     * @param b
     * @return
     */
    @GetMapping("/one")
    public String CityOne(@Valid @PathVariable String b) {
        return "one";
    }
}
