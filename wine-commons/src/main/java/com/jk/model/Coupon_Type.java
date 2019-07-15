package com.jk.model;

/**
 * @Classname Coupon_Type
 * @Description TODO
 * @Date 2019/7/14 17:52
 * @Created by jmh
 */
public class Coupon_Type {

    private Integer couponId;
    private String couponTypeName;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponTypeName() {
        return couponTypeName;
    }

    public void setCouponTypeName(String couponTypeName) {
        this.couponTypeName = couponTypeName;
    }
}