package com.jk.controller.shoppingCar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname Controller
 * @Description TODO
 * @Date 2019-07-11 19:48
 * @Created by 谷凌杰
 */
@Controller
public class CarController {

    @RequestMapping("toindex")
    public String toindex(){
        return "shoppingCar/index";
    }
}