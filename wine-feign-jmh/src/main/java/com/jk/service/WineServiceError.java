package com.jk.service;

import com.jk.model.Order;
import com.jk.model.User_Coupon;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> addReceive(Integer couponId, User_Coupon userCoupon) {
        return null;
    }

    @Override
    public HashMap<String, Object> getCouponNotUsed(Integer start, Integer pageSize) {
        return null;
    }

    @Override
    public HashMap<String, Object> getCouponUsed(Integer start, Integer pageSize) {
        return null;
    }

    @Override
    public HashMap<String, Object> getCouponExpired(Integer start, Integer pageSize) {
        return null;
    }

    @Override
    public HashMap<String, Object> getOrder(Integer start, Integer pageSize) {
        return null;
    }


}