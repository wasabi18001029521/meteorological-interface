package cn.webyun.meteorologicalinterface.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.lang.reflect.Array;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoArea extends Auto {
    // 中国地面自动站区域查询数据获取接口实体类

    private Integer level;

    private Number maxLon;

    private Number maxLat;

    private Number minLon;

    private Number minLat;

    private ArrayList<Integer> var;

    private String datatime;

    private String format;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Number getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(Number maxLon) {
        this.maxLon = maxLon;
    }

    public Number getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(Number maxLat) {
        this.maxLat = maxLat;
    }

    public Number getMinLon() {
        return minLon;
    }

    public void setMinLon(Number minLon) {
        this.minLon = minLon;
    }

    public Number getMinLat() {
        return minLat;
    }

    public void setMinLat(Number minLat) {
        this.minLat = minLat;
    }

    public ArrayList<Integer> getVar() {
        return var;
    }

    public void setVar(ArrayList<Integer> var) {
        this.var = var;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}
