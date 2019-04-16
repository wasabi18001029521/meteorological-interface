package cn.webyun.meteorologicalinterface.entity;

import javax.validation.constraints.NotBlank;

public class Auto {


    private String key;
    // 开始时间
    private String start;
    // 结束时间
    private String end;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public void removeKey() {
        this.key = null;
    }

}
