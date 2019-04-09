package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.InterfaceParame;
import cn.webyun.meteorologicalinterface.entity.InterfaceReturnData;

public interface RefinedUrbanForecastMapper {

    /**
     * 通过userKey等信息获取到InterfaceReturnData
     * @param interfaceParame
     * @return 查询需要的数据
     */
    public InterfaceReturnData findByParam(InterfaceParame interfaceParame);
}
