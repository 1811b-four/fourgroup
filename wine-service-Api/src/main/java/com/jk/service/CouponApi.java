package com.jk.service;

import com.jk.model.User_Coupon;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname CouponApi
 * @Description TODO
 * @Date 2019/7/24 23:21
 * @Created by jmh
 */
public interface CouponApi {

    @PostMapping("receive")
    Map<String, Object> addReceive(@RequestParam(value = "couponId", required = true) Integer couponId, User_Coupon userCoupon);

    @PostMapping("getCouponNotUsed")
    HashMap<String, Object> getCouponNotUsed(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize);

    @PostMapping("getCouponUsed")
    HashMap<String, Object> getCouponUsed(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize);

    @PostMapping("getCouponExpired")
    HashMap<String, Object> getCouponExpired(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize);

    @PostMapping("getOrder")
    HashMap<String, Object> getOrder(@RequestParam(value = "start",required = true) Integer start, @RequestParam(value = "pageSize",required = true) Integer pageSize);



}
