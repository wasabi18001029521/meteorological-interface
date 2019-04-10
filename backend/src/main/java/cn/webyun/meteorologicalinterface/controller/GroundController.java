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
    public AutoArea area(@Valid AutoArea autoArea) {
        try {
            String key = autoArea.getKey();
            System.out.println(key);
            // 查询当前时间
            String effective = userKeyVaildService.selectEffective(key);
            String s = userKeyVaildService.volitUserKey(effective);
            System.out.println(s);
            if (s.equals(true)) {
                return autoArea;
            }
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    // 中国地面自动站单站查询数据获取接口s
    @GetMapping("/one")
    public AutoOne one(@Valid AutoOne AutoOne){
        return AutoOne;
    }

    // 中国地面自动站最近站数据
    @GetMapping("/nearest")
    public Nearest nearest(@Valid Nearest nearest){
        return nearest;
    }
}
