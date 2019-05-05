
package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.controller.BaseController;
import cn.webyun.meteorologicalinterface.entity.AutoArea;
import cn.webyun.meteorologicalinterface.entity.AutoOne;
import cn.webyun.meteorologicalinterface.entity.Nearest;
import cn.webyun.meteorologicalinterface.entity.ShareInterfaceReturnsData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;


@Service
public class GroundService extends BaseController {
    @Resource
    private UserKeyVaildService userKeyVaildService;
    @Resource
    private UserService userService;

    ShareInterfaceReturnsData shareInterfaceReturnsData=new ShareInterfaceReturnsData();
    int lagtime;
    // 中国地面自动站区域查询数据获取接口
    public ShareInterfaceReturnsData getArea(AutoArea autoArea) {
        // 有效时间
       lagtime = userKeyVaildService.volitUserKey(autoArea.getKey(),1);
        ArrayList var = new ArrayList();
        var.add(18.62);
        var.add(120.26);
        // 默认时间
        if (shareInterfaceReturnsData.getDatatime() == null) {
            shareInterfaceReturnsData.setDatatime(userService.dataTime());
        }
        shareInterfaceReturnsData.setDt(2.5);
        shareInterfaceReturnsData.setLonlat(var);
        shareInterfaceReturnsData.setP(1300.0);
        shareInterfaceReturnsData.setPrec_1h(20.5);
        shareInterfaceReturnsData.setRh(18.0);
        shareInterfaceReturnsData.setStaCode("Area站点");
        shareInterfaceReturnsData.setT(9.2);
        shareInterfaceReturnsData.setWd(83.6);
        shareInterfaceReturnsData.setWs(5.0);
        return shareInterfaceReturnsData;
    }

    // 中国地面自动站单站查询数据获取接口
    public ShareInterfaceReturnsData getOne(AutoOne autoOne)  {
        // 有效时间
        lagtime = userKeyVaildService.volitUserKey(autoOne.getKey(),1);
        ArrayList var = new ArrayList();
        var.add(156.21);
        var.add(132.10);
        if (shareInterfaceReturnsData.getDatatime() == null) {
            shareInterfaceReturnsData.setDatatime(userService.dataTime());
        }
        shareInterfaceReturnsData.setDt(2.7);
        shareInterfaceReturnsData.setLonlat(var);
        shareInterfaceReturnsData.setP(1350.0);
        shareInterfaceReturnsData.setPrec_1h(22.5);
        shareInterfaceReturnsData.setRh(18.0);
        shareInterfaceReturnsData.setSlp(150.2);
        shareInterfaceReturnsData.setStaCode("One站点");
        shareInterfaceReturnsData.setT(9.2);
        shareInterfaceReturnsData.setWd(83.6);
        shareInterfaceReturnsData.setWs(5.0);
        return shareInterfaceReturnsData;
    }

    // 中国地面自动站最近站数据
    public ShareInterfaceReturnsData getNearest(Nearest nearest)  {
        // 有效时间
        lagtime = userKeyVaildService.volitUserKey(nearest.getKey(),5);
        ArrayList var = new ArrayList();
        var.add(19.56 );
        var.add(100.45);
        if (shareInterfaceReturnsData.getDatatime() == null) {
            shareInterfaceReturnsData.setDatatime(userService.dataTime());
        }
        shareInterfaceReturnsData.setDt(3.7);
        shareInterfaceReturnsData.setLonlat(var);
        shareInterfaceReturnsData.setP(1550.0);
        shareInterfaceReturnsData.setPrec_1h(12.5);
        shareInterfaceReturnsData.setRh(17.0);
        shareInterfaceReturnsData.setSlp(120.2);
        shareInterfaceReturnsData.setStaCode("Nearest站点");
        shareInterfaceReturnsData.setT(4.2);
        shareInterfaceReturnsData.setWd(80.6);
        shareInterfaceReturnsData.setWs(5.9);
        return shareInterfaceReturnsData;
    }

}

