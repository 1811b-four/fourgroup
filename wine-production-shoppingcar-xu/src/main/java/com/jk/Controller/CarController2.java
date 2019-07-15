package com.jk.Controller;

import com.jk.model.shoppingcar;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<shoppingcar> query() {
        return carServicePublic.query();
    }
}
