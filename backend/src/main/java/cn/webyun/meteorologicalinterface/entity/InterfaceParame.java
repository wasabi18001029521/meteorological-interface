package cn.webyun.meteorologicalinterface.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 传入的参数类型
 *
 * @NotBlank添加不为空注解,没有密匙报400错
 */
public class InterfaceParame implements Serializable {
    @NotBlank(message = "密钥必填")
    private String key;
    private String sid;
    private ArrayList elems;
    private String start;
    private String end;
    private Double lon;
    private Double lat;
    private Integer level;
    private Double maxLon;
    private Double maxLat;
    private Double minLon;
    private Double minLat;
    private ArrayList var;
    private String basetime;
    private String datatime;
    private String format;

    @Override
    public String toString() {
        return "InterfaceParame{" +
                "userkey='" + key + '\'' +
                ", sid='" + sid + '\'' +
                ", elems=" + elems +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", level=" + level +
                ", maxLon=" + maxLon +
                ", maxLat=" + maxLat +
                ", minLon=" + minLon +
                ", minLat=" + minLat +
                ", var=" + var +
                ", basetime='" + basetime + '\'' +
                ", datatime='" + datatime + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public ArrayList getElems() {
        return elems;
    }

    public void setElems(ArrayList elems) {
        this.elems = elems;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(Double maxLon) {
        this.maxLon = maxLon;
    }

    public Double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(Double maxLat) {
        this.maxLat = maxLat;
    }

    public Double getMinLon() {
        return minLon;
    }

    public void setMinLon(Double minLon) {
        this.minLon = minLon;
    }

    public Double getMinLat() {
        return minLat;
    }

    public void setMinLat(Double minLat) {
        this.minLat = minLat;
    }

    public ArrayList getVar() {
        return var;
    }

    public void setVar(ArrayList var) {
        this.var = var;
    }

    public String getBasetime() {
        return basetime;
    }

    public void setBasetime(String basetime) {
        this.basetime = basetime;
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
