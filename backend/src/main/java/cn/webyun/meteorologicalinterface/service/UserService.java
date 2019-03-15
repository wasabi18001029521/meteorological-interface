package cn.webyun.meteorologicalinterface.service;



import cn.webyun.meteorologicalinterface.Mapper.UserMapper;
import cn.webyun.meteorologicalinterface.entity.VueLoginInfoVo;
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

    //用户注册
    public void Register(VueLoginInfoVo vueLoginInfoVo){
        String username = vueLoginInfoVo.getUsername();
        String password = vueLoginInfoVo.getPassword();
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        System.out.println(sdf);
        userMapper.Register(username, password);

    }
//判断是否为邮箱
   public boolean email(VueLoginInfoVo vueLoginInfoVo){
       boolean tag = true;
       String youxiang = vueLoginInfoVo.getUsername();
       String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
       Pattern pattern = Pattern.compile(pattern1);
       Matcher mat = pattern.matcher(youxiang);

       if (!mat.find()) {
           tag = false;
       }
       return tag;
   }

   //判断用户名是否重复
    public boolean findusername(VueLoginInfoVo vueLoginInfoVo){
        boolean weiyyi = false;
        String username = vueLoginInfoVo.getUsername();
        List<String> findusername1 = userMapper.findusername();
        for(String attribute : findusername1) {
        if (attribute.equals(username)){
            System.out.println(attribute);
            weiyyi = true;

        }
        }
        return weiyyi;
    }


}
