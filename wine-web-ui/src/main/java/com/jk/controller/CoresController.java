package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/9 17:32
 * @Created by ${jmh}
 */
@Controller
public class CoresController {

    @RequestMapping("toConfirmOrder")
    public String toConfirmOrder(){
        return "xhs/confirmOrder";
    }



}
