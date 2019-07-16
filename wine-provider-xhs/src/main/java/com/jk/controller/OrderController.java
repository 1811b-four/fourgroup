package com.jk.controller;

import com.jk.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderServiceApi {

    @Autowired
    private OrderServiceApi orderServiceApi;

    @Override
    @GetMapping("add")
    public void add() {
        orderServiceApi.add();
    }
}
