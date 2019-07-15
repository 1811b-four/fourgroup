package com.jk.controller;

import com.jk.service.OrderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController{

    @Autowired
    private OrderServiceFeign orderServiceFeign;

}
