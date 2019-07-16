package com.jk.model;



import java.io.Serializable;


public class EchaBean  implements Serializable {

    private static final long serialVersionUID = 2617133398266532867L;
    private  Integer id;

    private  String name;

    private  Integer value;

    private  String group;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
