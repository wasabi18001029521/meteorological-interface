package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.message.request.LoginForm;
import cn.webyun.meteorologicalinterface.message.response.JwtResponse;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.security.JwtProvider;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class informationController {
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    UserService userService;


    @PostMapping("/information")
    @ResponseBody
    public ResponseEntity<?> user(@Valid  HttpServletRequest request) {
        
        try {
            // 获取请求头信息 从请求头中获取Token
            String token = request.getHeader("Authorization").split("\\s+")[1];
            // 解析Token获取用户名
            // String token="";
            String userNameFromJwtToken = jwtProvider.getUserNameFromJwtToken(token);
            // 根据用户名查找相应的用户信息
            System.out.println(userNameFromJwtToken);
            User user = userService.selectInformation(userNameFromJwtToken);
            //不晓得为什么查出来的用户名存不到User对象中只能手动先放进去了
            user.setUserName(userNameFromJwtToken);
            return ResponseEntity.ok(new JwtResponse( user,true,"账号信息"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseBase(false, "请重新登录"));
        }

    }
}
