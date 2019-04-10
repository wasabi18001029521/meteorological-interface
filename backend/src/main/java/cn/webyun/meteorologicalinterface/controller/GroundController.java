package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.entity.AutoArea;
import cn.webyun.meteorologicalinterface.entity.AutoOne;
import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.Nearest;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
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

    // 中国地面自动站区域查询数据获取接口
    @GetMapping("/area")
    public ResponseEntity<?> area(@Valid AutoArea autoArea)  {
        try {
            String key = autoArea.getKey();
            // 查询试用期时间
            int lagtime=userKeyVaildService.volitUserKey(key);
            if(lagtime<2){
                return ResponseEntity.ok(new ResponseBase(true, "200",autoArea));
            }else {
                return ResponseEntity.ok(new ResponseBase(false, "权限不足","401"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "服务异常","500"));
        }
    }


    // 中国地面自动站单站查询数据获取接口s
    @GetMapping("/one")
    public ResponseEntity<?> one(@Valid AutoOne autoOne){
        try {
            String key = autoOne.getKey();
            // 查询试用期时间
            int lagtime=userKeyVaildService.volitUserKey(key);
            if(lagtime<2){
                return ResponseEntity.ok(new ResponseBase(true, "200",autoOne));
            }else {
                return ResponseEntity.ok(new ResponseBase(false, "权限不足","401"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "服务异常","500"));
        }
    }

    // 中国地面自动站最近站数据
    @GetMapping("/nearest")
    public ResponseEntity<?> nearest(@Valid Nearest nearest) {
        try {
            String key = nearest.getKey();
            // 查询试用期时间
            int lagtime = userKeyVaildService.volitUserKey(key);
            if (lagtime < 2) {
                return ResponseEntity.ok(new ResponseBase(true, "200", nearest));
            }else {
            return ResponseEntity.ok(new ResponseBase(false, "权限不足","401"));
        }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "服务异常", "500"));
        }
    }
}
