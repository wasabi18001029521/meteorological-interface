package cn.webyun.meteorologicalinterface.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nearest extends Auto {

    private Number lon;
    private Number lat;
    private ArrayList<String> elems;



    public Number getLon() {
        return lon;
    }

    public void setLon(Number lon) {
        this.lon = lon;
    }

    public Number getLat() {
        return lat;
    }

    public void setLat(Number lat) {
        this.lat = lat;
    }

    public ArrayList<String> getElems() {
        return elems;
    }

    public void setElems(ArrayList<String> elems) {
        this.elems = elems;
    }


}
