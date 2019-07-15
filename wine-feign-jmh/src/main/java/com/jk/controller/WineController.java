package com.jk.controller;

import com.jk.model.User_Coupon;
import com.jk.service.WineServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname WineController
 * @Description TODO
 * @Date 2019/7/14 10:29
 * @Created by jmh
 */
@RestController
public class WineController {

    @Autowired
    private WineServiceFeign wineServiceFeign;

    @PostMapping("receive")
    public void addReceive(@RequestParam(value = "couponId",required = true) Integer couponId, User_Coupon userCoupon){
        wineServiceFeign.addReceive(couponId,userCoupon);
    }


}