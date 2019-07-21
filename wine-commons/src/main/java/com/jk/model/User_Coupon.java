package com.jk.model;

/**
 * @Classname User_Coupon
 * @Description TODO
 * @Date 2019/7/14 17:53
 * @Created by jmh
 */
public class User_Coupon {

    private Integer id;
    private Integer couponId;   //优惠券ID
    private Integer userId; //用户ID
    private String couponSerialNumber;  //序列号
    private Integer status; //优惠券状态     1.未使用    2.已使用    3.已过期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCouponSerialNumber() {
        return couponSerialNumber;
    }

    public void setCouponSerialNumber(String couponSerialNumber) {
        this.couponSerialNumber = couponSerialNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}