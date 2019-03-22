package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.entity.PasswordDo;
import cn.webyun.meteorologicalinterface.entity.UserDo;
import cn.webyun.meteorologicalinterface.service.PasswordService;
import cn.webyun.meteorologicalinterface.sysresult.Result;
import cn.webyun.meteorologicalinterface.sysresult.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


@Controller
@RequestMapping("/passworddo")
public class PasswordController {
@Resource
PasswordService passwordService;

    @CrossOrigin
    @RequestMapping(value = "/password", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result password1(@Valid @RequestBody PasswordDo passwordDo, BindingResult bindingResult) {
        //  修改密码后台
        //判断当前密码是否正确

        try{
        String password = passwordService.selectPassword(passwordDo);
        if(!passwordDo.getPassword().equals(password)){
            String message = String.format("请输入正确的密码");
            return ResultFactory.buildFailResult(message);
        }
        Integer row = passwordService.updatePassword(passwordDo);

        if(row!=1){
            String message = String.format("修改密码失败");
            return ResultFactory.buildFailResult(message);
        }
        return ResultFactory.buildSuccessResult("修改密码成功。");
    }catch (Exception e){
        e.printStackTrace();
        String message = String.format("失败]");
        return ResultFactory.buildFailResult(message);
    }

    }

    @CrossOrigin
    @RequestMapping(value = "/Retrieve", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result retrievePassword(@Valid @RequestBody PasswordDo passwordDo, BindingResult bindingResult){
        //找回密码
        return null;
    }

}
