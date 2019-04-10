package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Service
public class UserKeyVaildService {
    @Resource
    UserMapper userMapper;

    // userKey有限期验证
    public String volitUserKey(String effective) throws ParseException {
        // effective转换成毫秒值+7天时间转换的毫秒值
        String have="fasle";
        System.out.println("时间:"+effective);
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(effective));

        long timeInMillis = c.getTimeInMillis()+86400000*7;

        // 当前时间转换成毫秒值
        Date date=new java.util.Date();
        java.sql.Date  data1=new java.sql.Date(date.getTime());
        SimpleDateFormat sy1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateFormat=sy1.format(data1);

        Calendar d = Calendar.getInstance();
        d.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat));
        long timeInMillis1 = d.getTimeInMillis();
        System.out.println(timeInMillis1);

        if(timeInMillis>timeInMillis1){
           have="true";
            return have;
        }
        return have;
    }


    // 根据Key查询试用开始时间
    public String selectEffective(String key) {
        return userMapper.selectEffective(key);
    }
}
