package com.jk.model;

import lombok.Data;

/**
* @Description:    java类作用描述
* @Author:         张帅
* @CreateDate:     2019-07-15 20:03
* @UpdateUser:     梅赛德斯
* @UpdateDate:     2019-07-15 20:03
* @UpdateRemark:   ~~~
* @Version:        梅赛德斯
*/
@Data
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


}
