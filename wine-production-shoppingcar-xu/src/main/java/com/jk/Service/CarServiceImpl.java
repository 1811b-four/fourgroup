package com.jk.Service;

import com.jk.Mapper.CarMapper;
import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<shoppingcar> query() {
        return carMapper.query();
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
        return  carMapper.sumA();
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
    public void addFrom(Integer id, Integer sum) {
        t_commodity t = carMapper.queryListDetails(id);
        shoppingcar s = new shoppingcar();
        s.setGoods_img(t.getWineimg());
        s.setGoods_name(t.getWinename());
        s.setGoods_num(sum);
        BigDecimal big2 = new BigDecimal(t.getWinejiage().toString());
        s.setGoods_unit_price(big2);
        carMapper.addFrom(s);
    }


}
