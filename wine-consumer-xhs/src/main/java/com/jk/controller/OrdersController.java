package com.jk.controller;

import com.jk.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrderServiceApi orderServiceApi;

    @GetMapping("add")
    public void add(){
        orderServiceApi.add();
    }


}
