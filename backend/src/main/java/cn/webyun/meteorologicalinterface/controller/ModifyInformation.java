package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.entity.ChangePassword;
import cn.webyun.meteorologicalinterface.message.request.LoginForm;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/change")
public class ModifyInformation {
    @Resource
    UserService userService;


    @PostMapping("/password")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody ChangePassword changePassword ,HttpServletRequest request){
        try {
            // 获取用户输入密码
            String currentpassword=changePassword.getCurrentPassword();
            // 获取新密码
            String CheckPass=changePassword.getCheckPass();
            // 获取Tokne解析用户名
            String username = userService.getUsername(request);
            // 根据用户名查询原密码 进行匹配
            Boolean mistake = userService.getPassword(username, currentpassword);
            if(mistake ==false){
                return ResponseEntity.ok(new ResponseBase(false, "密码不正确"));
            }
            // 修改密码
            userService.modifyPassword(CheckPass,username);
            return ResponseEntity.ok(new ResponseBase(true, "修改密码成功"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "修改密码失败"));
        }

    }
}
