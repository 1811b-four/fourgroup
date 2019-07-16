package com.jk.service;

import com.jk.model.User_Coupon;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface WineServiceXhsApi {

    @PostMapping("receive")
    Boolean addReceive(@RequestParam(value = "couponId", required = true) Integer couponId, User_Coupon userCoupon);
}
