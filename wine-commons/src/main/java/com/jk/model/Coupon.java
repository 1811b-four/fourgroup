package com.jk.model;

/**
 * @Classname Coupon
 * @Description TODO
 * @Date 2019/7/14 17:42
 * @Created by jmh
 */
public class Coupon {

    private Integer couponId;
    private String couponName;  //名称
    private Integer couponFaceValue;    //面值
    private Integer couponTypeId;  //优惠券类型（外键）
    private String couponStartDate; //领取日期
    private String couponEndDate;   //结束日期
    private String couponTerminal;  //适用终端
    private Integer couponStatus;   //优惠券状态

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getCouponFaceValue() {
        return couponFaceValue;
    }

    public void setCouponFaceValue(Integer couponFaceValue) {
        this.couponFaceValue = couponFaceValue;
    }

    public Integer getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(Integer couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    public String getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(String couponStartDate) {
        this.couponStartDate = couponStartDate;
    }

    public String getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(String couponEndDate) {
        this.couponEndDate = couponEndDate;
    }

    public String getCouponTerminal() {
        return couponTerminal;
    }

    public void setCouponTerminal(String couponTerminal) {
        this.couponTerminal = couponTerminal;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }
}