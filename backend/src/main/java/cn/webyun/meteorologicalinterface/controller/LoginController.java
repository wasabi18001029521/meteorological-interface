package cn.webyun.meteorologicalinterface.controller;
import com.alibaba.fastjson.JSONObject;
import cn.webyun.meteorologicalinterface.entity.UserDo;
import cn.webyun.meteorologicalinterface.service.LoginUserService;
import cn.webyun.meteorologicalinterface.sysresult.Result;
import cn.webyun.meteorologicalinterface.sysresult.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/weather")
public class LoginController {
    @Resource
    LoginUserService loginUserService;


    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody UserDo userDo, BindingResult bindingResult) {
        JSONObject jsonObject=new JSONObject();

        if (userDo.getUsername().equals("")||userDo.getPassword().equals("")){
            String message = String.format("请输入邮箱或者密码");
            return ResultFactory.buildFailResult(message);
        }

        String password = loginUserService.selectUserPassword(userDo);
        if (userDo.getPassword().equals(password)) {
            String token = "";//jwtService.getToken(userDo);
            jsonObject.put("token", token);
            jsonObject.put("user", userDo.getUsername());

           // return ResultFactory.buildSuccessResult(jsonObject);
            return ResultFactory.buildSuccessResult("登录成功。");
        } else {
            String message = String.format("用户名或密码错误");
            return ResultFactory.buildFailResult(message);
        }
    }



    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

}