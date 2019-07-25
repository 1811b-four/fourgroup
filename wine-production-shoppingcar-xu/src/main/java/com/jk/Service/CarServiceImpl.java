package com.jk.Service;

import com.jk.Mapper.CarMapper;
import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.model.userBean;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Classname CarServiceImpl
 * @Description TODO
 * @Date 2019-07-12 19:27
 * @Created by 谷凌杰
 */
@Service
public class CarServiceImpl implements CarServicePublic {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<shoppingcar> query(String jmh) {
        Integer integer = Integer.valueOf(jmh);
        return carMapper.query(integer);
    }

    @Override
    public void addNum(Integer id) {
        carMapper.addNum(id);
    }

    @Override
    public void subNum(Integer id) {
        carMapper.subNum(id);
    }

    @Override
    public void subLostNum(Integer id) {
        carMapper.subLostNum(id);
    }

    @Override
    public void sddLostNum(Integer id) {
        carMapper.sddLostNum(id);
    }

    @Override
    public void LostNum(Integer id, Integer sum) {
        carMapper.LostNum(id,sum);
    }

    @Override
    public void del(Integer[] strIds) {
        carMapper.del(strIds);
    }

    @Override
    public void deleteA(Integer id) {
        carMapper.deleteA(id);
    }

    @Override
    public Integer sumA() {
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String name = "jmh";
        String jmh = jedis.get(name);
        Integer integer = Integer.valueOf(jmh);
        return  carMapper.sumA(integer);
    }

    @Override
    public List<t_commodity> queryDetails() {
        return carMapper.queryDetails();
    }

    @Override
    public t_commodity queryListDetails(Integer id) {

        return carMapper.queryListDetails(id);
    }

    @Override
    public void addFrom(Integer id, Integer sum,String jmh) {
        t_commodity t = carMapper.queryListDetails(id);
        shoppingcar s = new shoppingcar();
        s.setGoods_img(t.getWineimg());
        s.setGoods_name(t.getWinename());
        s.setGoods_num(sum);
        BigDecimal big2 = new BigDecimal(t.getWinejiage().toString());
        s.setGoods_unit_price(big2);
        Integer integer = Integer.valueOf(jmh);
        s.setUser_id(integer);
        carMapper.addFrom(s);
    }

    @Override
    public userBean queryaccount(String user_name) {
        return carMapper.queryaccount(user_name);
    }

    @Override
    public userBean findUserByLoginNumber(String phone) {
        return carMapper.findUserByLoginNumber(phone);
    }

    @Override
    public void Registration(userBean account) {
        account.setPid(1);
        carMapper.Registration(account);
    }


}
