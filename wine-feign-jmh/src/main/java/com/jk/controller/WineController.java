package com.jk.controller;

import com.jk.model.User_Coupon;
import com.jk.service.WineServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WineController
 * @Description TODO
 * @Date 2019/7/14 10:29
 * @Created by jmh
 */
@RestController
public class WineController {

    @Autowired
    private WineServiceFeign wineServiceFeign;

    @PostMapping("receive")
    public Map<String , Object> addReceive(@RequestParam(value = "couponId",required = true) Integer couponId, User_Coupon userCoupon){
        return wineServiceFeign.addReceive(couponId,userCoupon);
    }

    @PostMapping("getCouponNotUsed")
    public HashMap<String,Object> getCouponNotUsed(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize){
        return wineServiceFeign.getCouponNotUsed(start,pageSize);
    }

    @PostMapping("getCouponUsed")
    public HashMap<String,Object> getCouponUsed(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize){
        return wineServiceFeign.getCouponUsed(start,pageSize);
    }

    @PostMapping("getCouponExpired")
    public HashMap<String,Object> getCouponExpired(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize){
        return wineServiceFeign.getCouponExpired(start,pageSize);
    }


}