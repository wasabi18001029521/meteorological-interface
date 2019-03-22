package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.PasswordDo;
import cn.webyun.meteorologicalinterface.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PasswordService {
    @Resource
    UserMapper userMapper;

    // 修改密码
    public Integer updatePassword(PasswordDo passwordDo){
        String username = passwordDo.getUsername();
        String password = passwordDo.getNewpassword();

        return  userMapper.updatePassword(password,username);
    }

    // 查询当前密码
    public String selectPassword(PasswordDo passwordDo){
        String username = passwordDo.getUsername();
        return userMapper.selectPassword(username);
    }
}
