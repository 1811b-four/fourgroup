package com.jk.controller;

import com.jk.model.User_Coupon;
import com.jk.service.WineServiceXhsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Classname WineController
 * @Description TODO
 * @Date 2019/7/14 16:48
 * @Created by jmh
 */
@RestController
public class WineController2 implements WineServiceXhsApi {

    @Autowired
    private WineServiceXhsApi wineServiceXhsApi;

    @Override
    @PostMapping("receive")
    public Map<String, Object> addReceive(@RequestParam(value = "couponId", required = true) Integer couponId, User_Coupon userCoupon) {
        return wineServiceXhsApi.addReceive(couponId, userCoupon);
    }
}