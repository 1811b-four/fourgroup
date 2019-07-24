package com.jk.service;

import com.jk.model.Order;
import com.jk.model.shoppingcar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderServiceApi {

   @GetMapping("add")
   void add();

    @GetMapping("queryList")
    shoppingcar queryList(@RequestParam(value = "arr") String arr);
    @PostMapping("addOrders")
    void addOrders(@RequestBody Order order);
    @PostMapping("updStatus")
    void updStatus(@RequestParam(value = "outTradeNo") String outTradeNo);
}
