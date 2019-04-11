package cn.webyun.meteorologicalinterface.entity;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 返回的实体类数据类型
 */
public class ShareInterfaceReturnsData implements Serializable {
    private String datatime;
    private Double dt;
    private ArrayList lonlat;
    private Double p;
    private Double prec_1h;
    private Double rh;
    private Double slp;
    private String staCode;
    private Double t;
    private Double wd;
    private Double ws;

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public Double getDt() {
        return dt;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public ArrayList getLonlat() {
        return lonlat;
    }

    public void setLonlat(ArrayList lonlat) {
        this.lonlat = lonlat;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getPrec_1h() {
        return prec_1h;
    }

    public void setPrec_1h(Double prec_1h) {
        this.prec_1h = prec_1h;
    }

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Double getSlp() {
        return slp;
    }

    public void setSlp(Double slp) {
        this.slp = slp;
    }

    public String getStaCode() {
        return staCode;
    }

    public void setStaCode(String staCode) {
        this.staCode = staCode;
    }

    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }

    public Double getWs() {
        return ws;
    }

    public void setWs(Double ws) {
        this.ws = ws;
    }

    @Override
    public String toString() {
        return "ShareInterfaceReturnsData{" +
                "datatime='" + datatime + '\'' +
                ", dt=" + dt +
                ", lonlat=" + lonlat +
                ", p=" + p +
                ", prec_1h=" + prec_1h +
                ", rh=" + rh +
                ", slp=" + slp +
                ", staCode='" + staCode + '\'' +
                ", t=" + t +
                ", wd=" + wd +
                ", ws=" + ws +
                '}';

    }
}
