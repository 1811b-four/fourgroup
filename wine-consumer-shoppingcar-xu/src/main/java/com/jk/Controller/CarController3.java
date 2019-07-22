package com.jk.Controller;

import com.jk.model.Goods;
import com.jk.model.t_commodity;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname CarController3
 * @Description TODO
 * @Date 2019-07-21 16:39
 * @Created by 谷凌杰
 */
@RestController
@RequestMapping("shopp")
public class CarController3 {
    @Autowired
    private CarServicePublic carServicePublic;

    @GetMapping("queryListDetails")
    public ModelAndView queryListDetails(@RequestParam(value = "id", required = true)Integer id, Model model,ModelAndView mv){
        t_commodity goods = carServicePublic.queryListDetails(id);
        //PageModel list=carServicePublic.queryListDetails(id);
        model.addAttribute("c",goods);
        mv.setViewName("shoppingCar/details");
        return mv;
    }
}
