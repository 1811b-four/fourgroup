package com.jk.model;



import java.io.Serializable;


public class ParamBean implements Serializable {

    private static final long serialVersionUID = 6923303061775928496L;
    private  Integer type;

    private String maxdate;

    private  String mindate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMaxdate() {
        return maxdate;
    }

    public void setMaxdate(String maxdate) {
        this.maxdate = maxdate;
    }

    public String getMindate() {
        return mindate;
    }

    public void setMindate(String mindate) {
        this.mindate = mindate;
    }
}
