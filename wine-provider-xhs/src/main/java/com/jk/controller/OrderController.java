package com.jk.controller;

import com.jk.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderServiceApi {

    @Autowired
    private OrderServiceApi orderService;

    @Override
    public void add() {
        orderService.add();
    }
}
