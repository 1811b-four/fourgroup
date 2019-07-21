package com.jk.Controller;

import com.jk.model.Goods;
import com.jk.model.shoppingcar;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname Controller
 * @Description TODO
 * @Date 2019-07-12 19:20
 * @Created by 谷凌杰
 */
@RestController
@RequestMapping("shopping")
public class CarController1 {
    @Autowired
    private CarServicePublic carServicePublic;


    @GetMapping("query")
    public List<shoppingcar> query(){
        List<shoppingcar> query = carServicePublic.query();
        return query;
    }


    @PostMapping("addNum")
    public boolean addNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.addNum(id);
        return true;
    }

    @PostMapping("subNum")
    public boolean subNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.subNum(id);
        return true;
    }


    @PostMapping("sddLostNum")
    public boolean sddLostNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.sddLostNum(id);
        return true;
    }

    @PostMapping("subLostNum")
    public boolean subLostNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.subLostNum(id);
        return true;
    }

    @PostMapping("LostNum")
    public boolean LostNum(@RequestParam(value = "id", required = true) Integer id,@RequestParam(value = "sum", required = true) Integer sum){
        carServicePublic.LostNum(id,sum);
        return true;
    }


    @GetMapping("del")
    public boolean del(@RequestParam(value = "strIds", required = true) Integer[] strIds){
        carServicePublic.del(strIds);
        return true;
    }


    @PostMapping("deleteA")
    public boolean deleteA(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.deleteA(id);
        return true;
    }


    @PostMapping("sumA")
    public Integer sumA(){
        Integer integer = carServicePublic.sumA();
        return integer;
    }


    @GetMapping("queryDetails")
    public List<Goods> queryDetails(){
        List<Goods> queryDetails = carServicePublic.queryDetails();
        return queryDetails;
    }


}
