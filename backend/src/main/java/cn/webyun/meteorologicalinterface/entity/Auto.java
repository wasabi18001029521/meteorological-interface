package cn.webyun.meteorologicalinterface.entity;

import javax.validation.constraints.NotBlank;

public class Auto {

    @NotBlank(message = "密钥必填")
    private String key;
    private String start;
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
}
