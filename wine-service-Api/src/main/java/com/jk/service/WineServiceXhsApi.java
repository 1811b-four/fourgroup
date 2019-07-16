package com.jk.service;

import com.jk.model.User_Coupon;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface WineServiceXhsApi {

    @PostMapping("receive")
    Map<String, Object> addReceive(@RequestParam(value = "couponId", required = true) Integer couponId, User_Coupon userCoupon);
}
