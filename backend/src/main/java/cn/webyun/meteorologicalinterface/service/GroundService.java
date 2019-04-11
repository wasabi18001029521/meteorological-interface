package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.ServiceException.DataException;
import cn.webyun.meteorologicalinterface.entity.AutoArea;
import cn.webyun.meteorologicalinterface.entity.AutoOne;
import cn.webyun.meteorologicalinterface.entity.Nearest;
import cn.webyun.meteorologicalinterface.entity.ShareInterfaceReturnsData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@Service
public class GroundService {
    @Resource
    private UserKeyVaildService userKeyVaildService;
    @Resource
    private UserService userService;


    // 中国地面自动站区域查询数据获取接口
    public ShareInterfaceReturnsData getarea(AutoArea autoArea) throws TimeoutException {
        ShareInterfaceReturnsData shareInterfaceReturnsData=new ShareInterfaceReturnsData();
        // 有效时间
        int lagtime = userKeyVaildService.volitUserKey(autoArea.getKey(),1);
       /* if(lagtime>2){
         throw new TimeoutException();
        }
        return shareInterfaceReturnsData;*/
        if (shareInterfaceReturnsData.getDatatime() == null) {
            shareInterfaceReturnsData.setDatatime(userService.dataTime());
        }
        return shareInterfaceReturnsData;
    }

    // 中国地面自动站单站查询数据获取接口
    public ShareInterfaceReturnsData getone(AutoOne autoOne) throws TimeoutException {
        ShareInterfaceReturnsData shareInterfaceReturnsData=new ShareInterfaceReturnsData();
        // 有效时间
        int lagtime = userKeyVaildService.volitUserKey(autoOne.getKey(),1);
        if (shareInterfaceReturnsData.getDatatime() == null) {
            shareInterfaceReturnsData.setDatatime(userService.dataTime());
        }
        return shareInterfaceReturnsData;
    }

    // 中国地面自动站最近站数据
    public ShareInterfaceReturnsData getone(Nearest nearest) throws TimeoutException {
        ShareInterfaceReturnsData shareInterfaceReturnsData=new ShareInterfaceReturnsData();
        // 有效时间
        int lagtime = userKeyVaildService.volitUserKey(nearest.getKey(),1);
        if (shareInterfaceReturnsData.getDatatime() == null) {
            shareInterfaceReturnsData.setDatatime(userService.dataTime());
        }
        return shareInterfaceReturnsData;
    }

}
