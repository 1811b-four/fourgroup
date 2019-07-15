package com.jk.Controller;

import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
}
