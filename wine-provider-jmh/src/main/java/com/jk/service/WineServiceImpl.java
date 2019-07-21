package com.jk.service;


import com.jk.mapper.WineMapper;
import com.jk.model.Coupon;
import com.jk.model.User_Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    public Map<String, Object> addReceive(Integer couponId, User_Coupon userCoupon) {

        HashMap<String, Object> map = new HashMap<String, Object>();

        String date = new Date().toLocaleString();
        Coupon coupon = wineMapper.queryCoupinById(couponId);
        String start = coupon.getCouponStartDate();
        String end = coupon.getCouponEndDate();

        //查询当前用户所领取的当前券的数量
        Integer count = wineMapper.queryCouponCount(couponId);

        //start > date
        if (start.compareTo(date) > 0) {
            map.put("code", 1);
            map.put("msg", "Sorry！ 当前时间还不能领取哟，亲！");
            return map;
        }else if(start.compareTo(date) <= 0 & end.compareTo(date) >= 0 & count < 2){    //date = start  或者 date = end
                //优惠券序列号
                final int ACTIVATECODENUM = 1;
                Random random = new Random();
                String candicateCode = "abcdefghijklmnopqrstuvwxyz";
                candicateCode += candicateCode.toUpperCase();
                candicateCode += "1234567890";
                for (int i = 0; i < ACTIVATECODENUM; i++) {
                    String res = "";
                    for (int j = 0; j < 8; j++) {
                        res += candicateCode.charAt(random.nextInt(candicateCode.length()));
                    }
                    userCoupon.setCouponSerialNumber(res);
                    System.out.println(res);
                }
                //获取当前登录用户ID
                /*Jedis jedis = new Jedis("192.168.1.137",6379);
                jedis.auth("123");
                String name = "jmh";
                String s = jedis.get(name);
                int i = Integer.parseInt(s);*/
                int i = 1;
                userCoupon.setUserId(i);
                userCoupon.setCouponId(couponId);
                wineMapper.addReceive(userCoupon);

                map.put("code", 2);
                map.put("msg", "领取成功！爱你呦，亲！");
                return map;
        }else {  //date > end
            map.put("code", 3);
            map.put("msg", "请仔细阅读优惠券规则！！！");
            return map;
        }
    }
}