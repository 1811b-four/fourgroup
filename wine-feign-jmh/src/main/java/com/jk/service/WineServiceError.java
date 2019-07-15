package com.jk.service;

import com.jk.model.User_Coupon;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname WineServiceError
 * @Description TODO
 * @Date 2019/7/14 11:54
 * @Created by jmh
 */
@RequestMapping("/error")
@Component
public class WineServiceError implements WineServiceFeign {
    @Override
    public Boolean addReceive(Integer couponId, User_Coupon userCoupon) {
        return null;
    }
}