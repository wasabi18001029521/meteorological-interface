package cn.webyun.meteorologicalinterface.entity;

import java.util.ArrayList;

public class Nearest extends Auto {
    private Number lon;
    private Number lat;

    private ArrayList<String> array;

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


}
