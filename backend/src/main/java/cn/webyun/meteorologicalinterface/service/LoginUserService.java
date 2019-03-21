package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.UserDo;
import cn.webyun.meteorologicalinterface.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class LoginUserService {
    @Resource
    UserMapper userMapper;

    // 登录效验密码
    public String selectUserPassword(UserDo user){
        String username = user.getUsername();
        String password = userMapper.selectUserPassword(username);
        return password;
    }



}
