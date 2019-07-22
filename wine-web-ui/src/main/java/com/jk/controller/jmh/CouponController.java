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
        return "Coupon-Jmh/activity-1981";
    }

    //跳转我的优惠券
    @RequestMapping("toShow2")
    public String toShow2(){
        return "Coupon-Jmh/my_coupon-11";
    }

   /* @RequestMapping("toTop")
    public String toTop(){
        return "Coupon-Jmh/frame/top";
    }*/

    @RequestMapping("toPage2")
    public String toLeft(){
        return "Coupon-Jmh/page2";
    }

    @RequestMapping("toPage3")
    public String toMain(){
        return "Coupon-Jmh/page3";
    }

   /* @RequestMapping("toRight")
    public String toRight(){
        return "Coupon-Jmh/frame/right";
    }*/

    @RequestMapping("toUsed")
    public String toUsed(){
        return "Coupon-Jmh/Used";
    }

    @RequestMapping("toExpired")
    public String toExpired(){
        return "Coupon-Jmh/Expired";
    }
}