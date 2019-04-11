package cn.webyun.meteorologicalinterface.controller;


import cn.webyun.meteorologicalinterface.ServiceException.*;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个类的作用是
 * 定义常量
 * 处理异常
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public abstract class  BaseController {
    public static final String SUCCESS = "200";

    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<?> handlerException(
            Exception e){
        Integer state=null;
        String msg=null;
        if(e instanceof ParametersException){
            msg="参数异常";
            state=400;
        }else if(e instanceof PrivilegeException){
            msg="权限异常";
            state=401;
        }else if(e instanceof ForbiddenException){
            msg="Forbidden";
            state=403;
        }else if(e instanceof DataException){
            msg="数据异常";
            state=404;
        }else if(e instanceof ServerException){
            msg="数据异常";
            state=500;
        }
        return ResponseEntity.ok(new ResponseBase(true,msg, state));
    }
}
