package com.jk.Controller;

import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.model.userBean;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname CarController2
 * @Description TODO
 * @Date 2019-07-12 19:27
 * @Created by 谷凌杰
 */
@RestController
public class CarController2 implements CarServicePublic {
    @Autowired
    private CarServicePublic carServicePublic;

    @Override
    @GetMapping("query")
    public List<shoppingcar> query(@RequestParam(value = "jmh", required = true) String jmh) {
        return carServicePublic.query(jmh);
    }

    @Override
    @PostMapping("addNum")
    public void addNum(@RequestParam(value = "id", required = true) Integer id) {
        carServicePublic.addNum(id);
    }

    @Override
    @PostMapping("subNum")
    public void subNum(@RequestParam(value = "id", required = true)Integer id) {
        carServicePublic.subNum(id);
    }

    @Override
    @PostMapping("subLostNum")
    public void subLostNum(@RequestParam(value = "id", required = true)Integer id) {
        carServicePublic.subLostNum(id);
    }

    @Override
    @PostMapping("sddLostNum")
    public void sddLostNum(@RequestParam(value = "id", required = true)Integer id) {
        carServicePublic.sddLostNum(id);
    }

    @Override
    @PostMapping("LostNum")
    public void LostNum(@RequestParam(value = "id", required = true)Integer id,@RequestParam(value = "sum", required = true)Integer sum) {
        carServicePublic.LostNum(id,sum);
    }

    @Override
    @GetMapping("del")
    public void del(@RequestParam(value = "strIds", required = true)Integer[] strIds) {
        carServicePublic.del(strIds);
    }

    @Override
    @PostMapping("deleteA")
    public void deleteA(@RequestParam(value = "id", required = true)Integer id) {
        carServicePublic.deleteA(id);
    }

    @Override
    @PostMapping("sumA")
    public Integer sumA() {
        return carServicePublic.sumA();
    }

    @Override
    @GetMapping("queryDetails")
    public List<t_commodity> queryDetails() {
        return carServicePublic.queryDetails();
    }

    @Override
    @GetMapping("queryListDetails")
    public t_commodity queryListDetails(@RequestParam(value = "id", required = true)Integer id) {
        return carServicePublic.queryListDetails(id);
    }

    @Override
    @PostMapping("addFrom")
    public void addFrom(Integer id, Integer sum,String jmh) {
        carServicePublic.addFrom(id,sum,jmh);
    }

    @Override
    @PostMapping("queryaccount")
    public userBean queryaccount(String user_name) {
        return carServicePublic.queryaccount(user_name);
    }

    @Override
    @PostMapping("findUserByLoginNumber")
    public userBean findUserByLoginNumber(String phone) {
        return carServicePublic.findUserByLoginNumber(phone);
    }

    @Override
    @PostMapping("Registration")
    public void Registration(@RequestBody userBean account) {
        carServicePublic.Registration(account);
    }

}
