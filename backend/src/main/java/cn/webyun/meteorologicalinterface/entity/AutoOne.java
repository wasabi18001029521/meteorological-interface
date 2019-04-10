package cn.webyun.meteorologicalinterface.entity;

import javax.validation.constraints.NotBlank;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AutoOne {
    @NotBlank(message = "密钥必填")
    private String key;
    private String sid;
    private ArrayList<String> elems;
    private String start;
    private String end;

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

    public ArrayList<String> getElems() {
        return elems;
    }

    public void setElems(ArrayList<String> elems) {
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
}
