package com.jk.controller;

import com.jk.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrdersController {

    @Autowired
    private OrderServiceApi orderServiceApi;

    @GetMapping("add")
    public void add(){
        orderServiceApi.add();
    }

    /*@GetMapping("toConfirmOrder")
    public String toConfirmOrder(@RequestParam(value = "strIds", required = true) Integer[] strIds , ModelMap map){
        //List<shoppingcar> goodList = orderServiceApi.queryGoodsList(strIds);
        map.put("strIds",strIds);
        return "/xhs/confirmOrder";
    }*/

}
