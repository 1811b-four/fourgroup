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
@RequestMapping("shoppingCar")
public class CarController {

    @RequestMapping("toindex")
    public String toindex(){
        return "shoppingCar/index";
    }

    @RequestMapping("todetails")
    public String todetails(){
        return "shoppingCar/details";
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "shoppingCar/login";
    }

    @RequestMapping("toquickLogin")
    public String toquickLogin(){
        return "shoppingCar/quickLogin";
    }

    @RequestMapping("toregister")
    public String toregister(){
        return "shoppingCar/register";
    }

}
