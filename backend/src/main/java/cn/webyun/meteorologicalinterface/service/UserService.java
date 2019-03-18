package cn.webyun.meteorologicalinterface.service;



import cn.webyun.meteorologicalinterface.entity.UserDo;
import cn.webyun.meteorologicalinterface.mapper.UserMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    // 用户注册
    public void Register(UserDo userDo){
        String username = userDo.getUsername();
        String password = userDo.getPassword();
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        System.out.println(sdf);
        userMapper.insertRegister(username, password);

    }


    // 判断用户名是否重复
    public boolean findusername(UserDo userDo){
        boolean username = false;
        String key = userDo.getUsername();
        List<String> findusername1 = userMapper.selectUsername();
        for(String attribute : findusername1) {
        if (attribute.equals(key)){
            System.out.println(attribute);
            username = true;

        }
        }
        return username;
    }


}
