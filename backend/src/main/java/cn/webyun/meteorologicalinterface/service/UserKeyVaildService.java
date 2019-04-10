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
    public int volitUserKey(String key) throws ParseException {
       SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        String starttime=selectEffective(key);
        // 开始时间
        Date sdate = simpleDateFormat.parse(starttime);
        // 当前时间
        Date ndate = new Date();
        int lagtime = (int)(ndate.getTime()-sdate.getTime())/(24*60*60*1000);
        return lagtime;
    }


    // 根据Key查询试用开始时间
    private String selectEffective(String key) {
        return userMapper.selectEffective(key);
    }
}
