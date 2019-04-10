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

    /**
     * 通过密钥返回密钥已经生效的天数，不同产品根据天数自行判断逻辑
     * @param userkey
     * @return
     */
    public int volitUserKey(String userkey) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String starttime = selectEffective(userkey);
        Date sdate = null;//开始时间
        try {
            sdate = df.parse(starttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date ndate = new Date();//当前时间
            int lagtime = (int) (ndate.getTime() - sdate.getTime()) / (24 * 60 * 60 * 1000);
            System.out.println("天数差" + lagtime);
            return lagtime;

    }
    // 根据userKey查询试用开始时间
    private String selectEffective(String userkey) {
        return userMapper.selectEffective(userkey);
    }
}
