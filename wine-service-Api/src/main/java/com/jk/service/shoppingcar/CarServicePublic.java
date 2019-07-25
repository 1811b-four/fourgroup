package com.jk.service.shoppingcar;

import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.model.userBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Classname CarServicePublic
 * @Description TODO
 * @Date 2019-07-14 11:05
 * @Created by 谷凌杰
 */
public interface CarServicePublic {

    @GetMapping("query")
    List<shoppingcar> query(@RequestParam(value = "jmh", required = true)String jmh);

    @PostMapping("addNum")
    void addNum(@RequestParam(value = "id", required = true) Integer id);

    @PostMapping("subNum")
    void subNum(@RequestParam(value = "id", required = true)Integer id);

    @PostMapping("subLostNum")
    void subLostNum(@RequestParam(value = "id", required = true)Integer id);

    @PostMapping("sddLostNum")
    void sddLostNum(@RequestParam(value = "id", required = true)Integer id);

    @PostMapping("LostNum")
    void LostNum(@RequestParam(value = "id", required = true)Integer id,@RequestParam(value = "sum", required = true)Integer sum);

    @GetMapping("del")
    void del(@RequestParam(value = "strIds", required = true)Integer[] strIds);

    @PostMapping("deleteA")
    void deleteA(@RequestParam(value = "id", required = true)Integer id);

    @PostMapping("sumA")
    Integer sumA();

    @GetMapping("queryDetails")
    List<t_commodity> queryDetails();

    @GetMapping("queryListDetails")
    t_commodity queryListDetails(@RequestParam(value = "id", required = true)Integer id);

    @PostMapping("addFrom")
    void addFrom(@RequestParam(value = "id", required = true)Integer id,@RequestParam(value = "sum", required = true)Integer sum,@RequestParam(value = "jmh", required = true)String jmh);

    @PostMapping("queryaccount")
    userBean queryaccount(@RequestParam(value = "user_name", required = true)String user_name);

    @PostMapping("findUserByLoginNumber")
    userBean findUserByLoginNumber(@RequestParam(value = "phone", required = true)String phone);

    @PostMapping("Registration")
    void Registration(@RequestBody userBean account);



}
