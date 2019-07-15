package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/9 17:32
 * @Created by ${jmh}
 */
@Controller
public class CoresController {

    //跳转领券中心
    @RequestMapping("toShow")
    public String toShow(){
        return "activity-1981";
    }

    //跳转我的优惠券
    @RequestMapping("toShow2")
    public String toShow2(){
        return "my_coupon-11";
    }

}
