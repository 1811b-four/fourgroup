package com.jk.controller;

import com.jk.model.Order;
import com.jk.model.shoppingcar;
import com.jk.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController implements OrderServiceApi {

    @Autowired
    private OrderServiceApi orderServiceApi;

    @Override
    @GetMapping("add")
    public void add() {
        orderServiceApi.add();
    }

    @Override
    @GetMapping("queryList")
    public shoppingcar queryList(@RequestParam(value = "arr")String arr) {
        return orderServiceApi.queryList(arr);
    }

    @Override
    @PostMapping("addOrders")
    public void addOrders(@RequestBody Order order) {
        orderServiceApi.addOrders(order);
    }
}
