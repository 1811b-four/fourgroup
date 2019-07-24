package com.jk.service;

import com.jk.dao.OrderMapper;
import com.jk.model.Order;
import com.jk.model.shoppingcar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderServiceApi {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void add() {
        System.out.println("123");
    }

    @Override
    public shoppingcar queryList(String arr) {
        return orderMapper.queryList(arr);
    }

    @Override
    public void addOrders(Order order) {
        orderMapper.addOrders(order);
    }

    @Override
    public void updStatus(String outTradeNo) {
        orderMapper.updStatus(outTradeNo);
    }
}
