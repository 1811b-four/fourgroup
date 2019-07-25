package com.jk.service;


import com.jk.mapper.WineMapper;
import com.jk.model.Coupon;
import com.jk.model.Order;
import com.jk.model.User_Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Classname WineServiceImpl
 * @Description TODO
 * @Date 2019/7/14 16:56
 * @Created by jmh
 */
@Service
public class WineServiceImpl implements CouponApi {

    @Autowired
    private WineMapper wineMapper;

    @Override
    public Map<String, Object> addReceive(Integer couponId, User_Coupon userCoupon) {

        HashMap<String, Object> map = new HashMap<String, Object>();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);

        Coupon coupon = wineMapper.queryCoupinById(couponId);
        String start = coupon.getCouponStartDate();
        String end = coupon.getCouponEndDate();

        //查询当前用户所领取的当前券的数量
        Integer count = wineMapper.queryCouponCount(couponId);

        //start > date
        if (start.compareTo(format) > 0) {
            map.put("code", 1);
            map.put("msg", "Sorry！ 当前时间还不能领取哟，亲！");
            return map;
        }else if(start.compareTo(format) <= 0 & end.compareTo(format) >= 0 & count < 2){    //date = start  或者 date = end
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
                Jedis jedis = new Jedis("192.168.1.122",6379);
                jedis.auth("123456");
                String name = "jmh";
                String s = jedis.get(name);
                int i = Integer.parseInt(s);
                //int i = 1;
                userCoupon.setUserId(i);
                userCoupon.setCouponId(couponId);
                userCoupon.setStatus(1);
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

    @Override
    public HashMap<String, Object> getCouponNotUsed(Integer start, Integer pageSize) {

        //获取当前登录用户ID
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String name = "jmh";
        String s = jedis.get(name);
        int i = Integer.parseInt(s);
        //int i = 1;

        HashMap<String, Object> hash = new HashMap<>();
        //查询总条数
        int count = wineMapper.findCouponCount(i);
        //将查询出来的总条数放到总返回体中--2
        hash.put("total",count);
        //查询分页列表
        List<User_Coupon> coupon= wineMapper.getCouponList(start,pageSize,i);
        hash.put("rows",coupon);
        return hash;
    }

    @Override
    public HashMap<String, Object> getCouponUsed(Integer start, Integer pageSize) {
        //获取当前登录用户ID
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String name = "jmh";
        String s = jedis.get(name);
        int i = Integer.parseInt(s);
        //int i = 1;

        HashMap<String, Object> hash = new HashMap<>();
        //查询总条数
        int count = wineMapper.findCouponCount2(i);
        //将查询出来的总条数放到总返回体中--2
        hash.put("total",count);
        //查询分页列表
        List<User_Coupon> coupon= wineMapper.getCouponList2(start,pageSize,i);
        hash.put("rows",coupon);
        return hash;
    }

    @Override
    public HashMap<String, Object> getCouponExpired(Integer start, Integer pageSize) {
        //获取当前登录用户ID
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String name = "jmh";
        String s = jedis.get(name);
        int i = Integer.parseInt(s);
        //int i = 1;

        HashMap<String, Object> hash = new HashMap<>();
        //查询总条数
        int count = wineMapper.findCouponCount3(i);
        //将查询出来的总条数放到总返回体中--2
        hash.put("total",count);
        //查询分页列表
        List<User_Coupon> coupon= wineMapper.getCouponList3(start,pageSize,i);
        hash.put("rows",coupon);
        return hash;
    }

    @Override
    public HashMap<String, Object> getOrder(Integer start, Integer pageSize) {
        //获取当前登录用户ID
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String name = "jmh";
        String s = jedis.get(name);
        int i = Integer.parseInt(s);
        //int i = 1;

        HashMap<String, Object> hash = new HashMap<>();
        //查询总条数
        int count = wineMapper.findOrderCount(i);
        //将查询出来的总条数放到总返回体中--2
        hash.put("total",count);
        //查询分页列表
        List<Order> coupon= wineMapper.getOrderList(start,pageSize,i);
        hash.put("rows",coupon);
        return hash;
    }
}