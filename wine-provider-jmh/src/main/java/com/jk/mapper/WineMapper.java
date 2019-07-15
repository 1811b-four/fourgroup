package com.jk.mapper;

import com.jk.model.User_Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname WineMapper
 * @Description TODO
 * @Date 2019/7/14 16:51
 * @Created by jmh
 */
@Mapper
public interface WineMapper {
    Boolean addReceive(User_Coupon userCoupon);
}
