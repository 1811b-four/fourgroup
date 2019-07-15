package com.jk.service;

import com.jk.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderServiceApi {

    @Autowired
    private OrderMapper orderMapper;


}
