package cn.webyun.meteorologicalinterface;

import cn.webyun.meteorologicalinterface.mapper.UserMapper;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeteorologicalInterfaceApplicationTests {
@Resource
    UserService userService;
@Resource
    UserMapper userMapper;
    @Test
    public void contextLoads() throws ParseException {
//        List<String> findusername1 = userMapper.findusername();
//        for(String attribute : findusername1) {
//            if(attribute.equals("admin")){
//
//            }
//            System.out.println(attribute);
//        }

       /* long l = System.currentTimeMillis();
        Date time=new Date(l);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.toString();
        System.out.println(sdf.format(time));*/
/*Date  date=new java.util.Date();
        String username="zxc@123.com";
        java.sql.Date  data1=new java.sql.Date(date.getTime());
        SimpleDateFormat sy1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String dateFormat=sy1.format(data1);
        System.out.println(dateFormat);
        userMapper.updateTime(dateFormat,username);*/

   /*     Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-04-10 12:04:48"));
        long timeInMillis = c.getTimeInMillis()+86400000*7;
        System.out.println(timeInMillis);*/

    /*    String s = userMapper.selectEffective("ae566413a4d15dfc90bc43152100178c");
        System.out.println(s);*/

    // 时间测试
    /*    String a= "yyyy-MM-dd";
        String s = userService.dataTime2(a);
        System.out.println(s);*/
    }




}
