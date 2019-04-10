package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.ServiceException.PrivilegeException;
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
     * 接收userkey和可用时间,做验证，若当前天数差>可用时间，返回false
     * @param userkey
     * @return
     */
    public int volitUserKey(String userkey,int day) throws PrivilegeException{
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
            //返回产品使用至今天数是否大于有效期天数，若大于，权限异常，否则
        if(lagtime>day){
            throw new PrivilegeException();
        }else{
            return day-lagtime;
        }

    }
    // 根据userKey查询试用开始时间
    private String selectEffective(String userkey) {
        return userMapper.selectEffective(userkey);
    }
}
