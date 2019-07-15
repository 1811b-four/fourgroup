package com.jk.service;


import com.jk.mapper.WineMapper;
import com.jk.model.User_Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import java.util.Random;

/**
 * @Classname WineServiceImpl
 * @Description TODO
 * @Date 2019/7/14 16:56
 * @Created by jmh
 */
@Service
public class WineServiceImpl implements WineServiceXhsApi {

    @Autowired
    private WineMapper wineMapper;

    @Override
    public Boolean addReceive(Integer couponId, User_Coupon userCoupon) {

        final int ACTIVATECODENUM = 1;
        Random random = new Random();
        String candicateCode = "abcdefghijklmnopqrstuvwxyz";
        candicateCode += candicateCode.toUpperCase();
        candicateCode += "1234567890";
        for(int i = 0; i < ACTIVATECODENUM; i++){
            String res = "";
            for(int j = 0; j < 8; j++){
                res += candicateCode.charAt(random.nextInt(candicateCode.length()));
            }
            userCoupon.setCouponSerialNumber(res);
            System.out.println(res);
        }


        /*Jedis jedis = new Jedis("192.168.1.137",6379);
        jedis.auth("123");
        String name = "jmh";
        String s = jedis.get(name);
        int i = Integer.parseInt(s);*/
        int i = 1;
        userCoupon.setUserId(i);
        userCoupon.setCouponId(couponId);

        return wineMapper.addReceive(userCoupon);
    }
}