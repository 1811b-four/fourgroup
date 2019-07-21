package com.jk.model;
/**
* @Description:    java类作用描述
* @Author:         张帅
* @CreateDate:     2019-07-15 20:03
* @UpdateUser:     梅赛德斯
* @UpdateDate:     2019-07-15 20:03
* @UpdateRemark:   ~~~
* @Version:        梅赛德斯
*/
public class t_commodity {

    private Integer wineid;		    //编号
    private String winename;		//酒名称
    private Integer winetypeid;		//酒类型
    private Integer wingpinpaiid;	//酒品牌
    private  Integer winedushuid;		  //	酒度数id
    private  Integer wingchandiid;	    //	产地id
    private  Integer winehanliangid;	    //	净含量id
    private  Integer wingguigeid;		  //	规格id



    private String wineyuanliao;	//原料(水,高粱,小麦)
    private String wingxiangxing;	//香型(酱香型,浓香型)
    private Integer winejiage;	    //价格
    private String winejiuchang;	//酒厂(中国四川仙潭酒厂)
    private String wineimg;          //商品图片



    private  String   winetype;   //类型
    private  String  wingpinpai;   //品牌

    private  String  wingchandi;   //产地(中国,四川)
    private  Integer  winehanliang;   //净含量
    private  Integer  winedushu;   //酒精度
    private  String  wingguige ;   //酒规格(6瓶 * 1箱)

    public String getWinetype() {
        return winetype;
    }

    public void setWinetype(String winetype) {
        this.winetype = winetype;
    }

    public String getWingpinpai() {
        return wingpinpai;
    }

    public void setWingpinpai(String wingpinpai) {
        this.wingpinpai = wingpinpai;
    }

    public String getWineshuxing() {
        return wineshuxing;
    }

    public void setWineshuxing(String wineshuxing) {
        this.wineshuxing = wineshuxing;
    }

    public String getWineimg() {
        return wineimg;
    }

    public void setWineimg(String wineimg) {
        this.wineimg = wineimg;
    }

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

    public Integer getWinetypeid() {
        return winetypeid;
    }

    public void setWinetypeid(Integer winetypeid) {
        this.winetypeid = winetypeid;
    }

    public Integer getWingpinpaiid() {
        return wingpinpaiid;
    }

    public void setWingpinpaiid(Integer wingpinpaiid) {
        this.wingpinpaiid = wingpinpaiid;
    }

    public Integer getWineshuxingid() {
        return wineshuxingid;
    }

    public void setWineshuxingid(Integer wineshuxingid) {
        this.wineshuxingid = wineshuxingid;
    }

    public String getWineyuanliao() {
        return wineyuanliao;
    }

    public void setWineyuanliao(String wineyuanliao) {
        this.wineyuanliao = wineyuanliao;
    }

    public String getWingxiangxing() {
        return wingxiangxing;
    }

    public void setWingxiangxing(String wingxiangxing) {
        this.wingxiangxing = wingxiangxing;
    }

    public String getWingchandi() {
        return wingchandi;
    }

    public void setWingchandi(String wingchandi) {
        this.wingchandi = wingchandi;
    }

    public Integer getWinehanliang() {
        return winehanliang;
    }

    public void setWinehanliang(Integer winehanliang) {
        this.winehanliang = winehanliang;
    }

    public Integer getWinedushu() {
        return winedushu;
    }

    public void setWinedushu(Integer winedushu) {
        this.winedushu = winedushu;
    }

    public String getWingguige() {
        return wingguige;
    }

    public void setWingguige(String wingguige) {
        this.wingguige = wingguige;
    }

    public String getWinejiuchang() {
        return winejiuchang;
    }

    public void setWinejiuchang(String winejiuchang) {
        this.winejiuchang = winejiuchang;
    }
}
