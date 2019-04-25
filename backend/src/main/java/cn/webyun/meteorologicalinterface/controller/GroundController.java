package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.ServiceException.ParametersException;
import cn.webyun.meteorologicalinterface.entity.*;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.service.GroundService;
import cn.webyun.meteorologicalinterface.service.UserKeyVaildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.LinkedHashMap;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/station/auto")
public class GroundController extends BaseController {
    @Resource
    UserKeyVaildService userKeyVaildService;
    @Resource
    GroundService groundService;


    private LinkedHashMap<String, Object> hashMap = new LinkedHashMap();
    ShareInterfaceReturnsData shareInterfaceReturnsData;
    // 中国地面自动站区域查询数据获取接口
    @GetMapping("/area")
    public ResponseEntity<?> area(@Valid AutoArea autoArea) {
       /* System.out.println(autoArea.getMaxLon()+"+"+autoArea.getMaxLat()+"+"+
                autoArea.getMinLat()+"+"+autoArea.getMinLon()+"+"+
                autoArea.getVar()+"+"+autoArea.getLevel());*/
        if(autoArea.getMaxLon()==null||autoArea.getMaxLat()==null||
                autoArea.getMinLat()==null||autoArea.getMinLon()==null||
                autoArea.getVar()==null||autoArea.getLevel()==null){
            throw new ParametersException("参数异常");
        }
        // System.out.println(autoArea.getMaxLat());
        // hashMap.put("location", autoArea);
        shareInterfaceReturnsData = groundService.getArea(autoArea);
        hashMap.put("now", shareInterfaceReturnsData);
        return ResponseEntity.ok(new ResponseBase(hashMap));
    }


    // 中国地面自动站单站查询数据获取接口
    @GetMapping("/one")
    public ResponseEntity<?> one(@Valid AutoOne autoOne) {
       /* System.out.println(autoOne.getSid()+"+"+autoOne.getElems()+"+"+
                autoOne.getStart()+"+"+autoOne.getEnd());*/
        if(autoOne.getSid()==null||autoOne.getElems()==null||
                autoOne.getStart()==null||autoOne.getEnd()==null){
            throw new ParametersException("参数异常");
        }
        shareInterfaceReturnsData = groundService.getOne(autoOne);
        // hashMap.put("location", autoOne);
        hashMap.put("now", shareInterfaceReturnsData);
        return ResponseEntity.ok(new ResponseBase(hashMap));

    }

    // 中国地面自动站最近站数据
    @GetMapping("/nearest")
    public ResponseEntity<?> nearest(@Valid Nearest nearest) {
      /*  System.out.println(nearest.getLon()+"+"+nearest.getLat()+"+"+
                nearest.getStart()+"+"+nearest.getEnd()+"+"+nearest.getElems()+"+");*/
        if(nearest.getLon()==null||nearest.getLat()==null||
                nearest.getStart()==null||nearest.getEnd()==null
                ||nearest.getElems()==null){
            throw new ParametersException("参数异常");
        }
        shareInterfaceReturnsData = groundService.getNearest(nearest);
        // hashMap.put("location", nearest);
        hashMap.put("now", shareInterfaceReturnsData);
        return ResponseEntity.ok(new ResponseBase(hashMap));
    }



}

