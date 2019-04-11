package cn.webyun.meteorologicalinterface.controller;

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
import java.text.ParseException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/station/auto")
public class GroundController {
    @Resource
    UserKeyVaildService userKeyVaildService;
    @Resource
    GroundService groundService;
    // 中国地面自动站区域查询数据获取接口
    @GetMapping("/area")
    public ResponseEntity<?> area(@Valid AutoArea autoArea)  {

        ShareInterfaceReturnsData shareInterfaceReturnsData =new ShareInterfaceReturnsData();
        try {
            // 查询试用期时间
            shareInterfaceReturnsData=groundService.getarea(autoArea);
            return ResponseEntity.ok(new ResponseBase(true, "200",shareInterfaceReturnsData));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "服务异常","500"));
        }
    }


    // 中国地面自动站单站查询数据获取接口
    @GetMapping("/one")
    public ResponseEntity<?> one(@Valid AutoOne autoOne){
        ShareInterfaceReturnsData shareInterfaceReturnsData =new ShareInterfaceReturnsData();
        try {
            // 查询试用期时间
            shareInterfaceReturnsData=groundService.getone(autoOne);
            return ResponseEntity.ok(new ResponseBase(true, "200",shareInterfaceReturnsData));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "服务异常","500"));
        }
    }

    // 中国地面自动站最近站数据
    @GetMapping("/nearest")
    public ResponseEntity<?> nearest(@Valid Nearest nearest) {
        ShareInterfaceReturnsData shareInterfaceReturnsData =new ShareInterfaceReturnsData();
        try {
            // 查询试用期时间
            shareInterfaceReturnsData=groundService.getone(nearest);
            return ResponseEntity.ok(new ResponseBase(true, "200",shareInterfaceReturnsData));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "服务异常","500"));
        }
    }
}
