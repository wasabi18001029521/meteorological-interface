
package cn.webyun.meteorologicalinterface.Controller;


import cn.webyun.meteorologicalinterface.entity.VueLoginInfoVo;
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
    @RequestMapping(value = "/zhuce", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {


        //用户注册
        if (loginInfoVo.getUsername().equals("")||loginInfoVo.getPassword().equals("")){
            System.out.println(loginInfoVo.getUsername());
            String message = String.format("请输入用户名或者密码");

            return ResultFactory.buildFailResult(message);
        }


        //y邮箱验证
        boolean a = userService.email(loginInfoVo);
        if(a!=true){
            String message = String.format("请输入正确的邮箱");
            return ResultFactory.buildFailResult(message);
        }
        boolean b = userService.findusername(loginInfoVo);
        if(b==true){
            String message = String.format("邮箱已被注册");
            return ResultFactory.buildFailResult(message);
        }


        try{
            userService.Register(loginInfoVo);
            return ResultFactory.buildSuccessResult("注册成功。");
        }catch (Exception e){
            e.printStackTrace();
            String message = String.format("注册失败]");
            return ResultFactory.buildFailResult(message);
        }

    }


    }
