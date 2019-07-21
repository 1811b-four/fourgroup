package com.jk.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/21 18:18
 * @Created by ${jmh}
 */
@Document(indexName = "wine",type = "wineInfo")
public class ElasticBean implements Serializable {


    private static final long serialVersionUID = -6204976569917205778L;
         @Id
         private  Integer   id;

         private  Integer   wineid;

         private   String   winename;

         private    Integer winejiage;


    public Integer getWineid() {
        return wineid;
    }

    public void setWineid(Integer wineid) {
        this.wineid = wineid;
    }

    public String getWinename() {
        return winename;
    }

    public void setWinename(String winename) {
        this.winename = winename;
    }

    public Integer getWinejiage() {
        return winejiage;
    }

    public void setWinejiage(Integer winejiage) {
        this.winejiage = winejiage;
    }
}
