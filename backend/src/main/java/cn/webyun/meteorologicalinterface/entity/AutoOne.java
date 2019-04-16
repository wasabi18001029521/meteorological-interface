package cn.webyun.meteorologicalinterface.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.lang.reflect.Array;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoOne extends Auto {

    private String sid;
    private ArrayList<String> elems;


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


}
