package com.jk.model;



import java.io.Serializable;
import java.util.List;



public class TreeBean implements Serializable {


    private static final long serialVersionUID =2L;

    private  Integer id;

    private  String  text;

    private   String  url;

    private   Integer  pid;



    private   List Nodes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List getNodes() {
        return Nodes;
    }

    public void setNodes(List nodes) {
        Nodes = nodes;
    }
}
