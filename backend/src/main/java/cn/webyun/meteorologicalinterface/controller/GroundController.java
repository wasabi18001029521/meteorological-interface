package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.entity.*;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.message.response.ResponseModel;
import cn.webyun.meteorologicalinterface.service.GroundService;
import cn.webyun.meteorologicalinterface.service.UserKeyVaildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/station/auto")
public class GroundController extends BaseController {
    @Resource
    UserKeyVaildService userKeyVaildService;
    @Resource
    GroundService groundService;


    private LinkedHashMap<String, Object> hashMap = new LinkedHashMap();

    // 中国地面自动站区域查询数据获取接口
    @GetMapping("/area")
    public ResponseEntity<?> area(@Valid AutoArea autoArea) {
        hashMap.put("location", autoArea);
        ShareInterfaceReturnsData shareInterfaceReturnsData = groundService.getarea(autoArea);
        hashMap.put("now", shareInterfaceReturnsData);
        return ResponseEntity.ok(new ResponseModel(hashMap));
    }


    // 中国地面自动站单站查询数据获取接口
    @GetMapping("/one")
    public ResponseEntity<?> one(@Valid AutoOne autoOne) {
        ShareInterfaceReturnsData shareInterfaceReturnsData = groundService.getone(autoOne);
        hashMap.put("location", autoOne);
        hashMap.put("now", shareInterfaceReturnsData);
        return ResponseEntity.ok(new ResponseModel(hashMap));

    }

    // 中国地面自动站最近站数据
    @GetMapping("/nearest")
    public ResponseEntity<?> nearest(@Valid Nearest nearest) {
        ShareInterfaceReturnsData shareInterfaceReturnsData = groundService.getone(nearest);
        hashMap.put("location", nearest);
        hashMap.put("now", shareInterfaceReturnsData);
        return ResponseEntity.ok(new ResponseModel(hashMap));
    }
}

