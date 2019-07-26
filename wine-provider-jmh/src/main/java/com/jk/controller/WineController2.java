package com.jk.controller;

import com.jk.model.User_Coupon;
import com.jk.service.CouponApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WineController
 * @Description TODO
 * @Date 2019/7/14 16:48
 * @Created by jmh
 */
@RestController
public class WineController2 implements CouponApi {

    @Autowired
    private CouponApi coupon;

    @Override
    @PostMapping("receive")
    public Map<String, Object> addReceive(@RequestParam(value = "couponId", required = true) Integer couponId, User_Coupon userCoupon) {
        return coupon.addReceive(couponId, userCoupon);
    }

    @Override
    @PostMapping("getCouponNotUsed")
    public HashMap<String, Object> getCouponNotUsed(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize) {
        return coupon.getCouponNotUsed(start,pageSize);
    }

    @Override
    @PostMapping("getCouponUsed")
    public HashMap<String, Object> getCouponUsed(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize) {
        return coupon.getCouponUsed(start,pageSize);
    }

    @Override
    @PostMapping("getCouponExpired")
    public HashMap<String, Object> getCouponExpired(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize) {
        return coupon.getCouponExpired(start,pageSize);
    }

    @Override
    @PostMapping("getOrder")
    public HashMap<String, Object> getOrder(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize) {
        return coupon.getOrder(start,pageSize);
    }
}