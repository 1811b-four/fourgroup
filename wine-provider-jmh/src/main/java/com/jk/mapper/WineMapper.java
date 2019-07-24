package com.jk.mapper;

import com.jk.model.Coupon;
import com.jk.model.Order;
import com.jk.model.User_Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname WineMapper
 * @Description TODO
 * @Date 2019/7/14 16:51
 * @Created by jmh
 */
@Mapper
public interface WineMapper {
    void addReceive(User_Coupon userCoupon);

    Coupon queryCoupinById(@Param("couponId") Integer couponId);

    Integer queryCouponCount(@Param("couponId") Integer couponId);

    int findCouponCount(@Param("userId") int i);

    List<User_Coupon> getCouponList(@Param("start") Integer start, @Param("pageSize") Integer pageSize,@Param("userId") int i);

    int findCouponCount2(@Param("userId")int i);

    List<User_Coupon> getCouponList2(@Param("start")Integer start,@Param("pageSize") Integer pageSize,@Param("userId") int i);

    int findCouponCount3(@Param("userId")int i);

    List<User_Coupon> getCouponList3(@Param("start")Integer start,@Param("pageSize") Integer pageSize,@Param("userId") int i);

    int findOrderCount(@Param("userId")int i);

    List<Order> getOrderList(@Param("start")Integer start, @Param("pageSize") Integer pageSize, @Param("userId") int i);
}
