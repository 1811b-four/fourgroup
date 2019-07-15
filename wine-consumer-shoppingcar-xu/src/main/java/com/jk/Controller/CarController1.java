package com.jk.Controller;

import com.jk.model.shoppingcar;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
