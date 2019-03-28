package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.message.request.LoginForm;
import cn.webyun.meteorologicalinterface.message.response.JwtResponse;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.service.UserService;
import cn.webyun.meteorologicalinterface.sysresult.Result;
import cn.webyun.meteorologicalinterface.sysresult.ResultFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Resource
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody LoginForm loginRequest){
        try {
            // 获取用户输入邮箱
            String username = loginRequest.getUsername();
            if(userService.selectUsername(username)!=null){
                return ResponseEntity.ok(new ResponseBase(false, "邮箱已被注册"));
            }
            // 对密码进行加密
            String password=new BCryptPasswordEncoder().encode(loginRequest.getPassword());
            // 用户名进行32位MD5加密生产key
            String md5username = userService.MD5(username);
            userService.insertUser(username,password,md5username);
            //为新用户设置默认可以访问的接口
            userService.insertUser(username);
            return ResponseEntity.ok(new ResponseBase(true, "注册成功"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "注册失败"));
        }

    }
}
