package com.jk.controller.jmh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname CouponController
 * @Description TODO
 * @Date 2019/7/16 14:13
 * @Created by jmh
 */
@Controller
public class CouponController {

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