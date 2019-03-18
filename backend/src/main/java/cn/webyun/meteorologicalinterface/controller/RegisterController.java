
package cn.webyun.meteorologicalinterface.controller;


import cn.webyun.meteorologicalinterface.entity.UserDo;
import cn.webyun.meteorologicalinterface.service.UserService;
import cn.webyun.meteorologicalinterface.sysresult.Result;
import cn.webyun.meteorologicalinterface.sysresult.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/weather")
public class RegisterController {
    @Resource
    UserService userService;


    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody UserDo userDo, BindingResult bindingResult) {


        // 用户注册
        if (userDo.getUsername().equals("")||userDo.getPassword().equals("")){
            String message = String.format("请输入用户名或者密码");
            return ResultFactory.buildFailResult(message);
        }


        // 邮箱验证
        boolean username = userService.findusername(userDo);
        if(username==true){
            String message = String.format("邮箱已被注册");
            return ResultFactory.buildFailResult(message);
        }


        try{
            userService.Register(userDo);
            return ResultFactory.buildSuccessResult("注册成功。");
        }catch (Exception e){
            e.printStackTrace();
            String message = String.format("注册失败]");
            return ResultFactory.buildFailResult(message);
        }

    }


    }
