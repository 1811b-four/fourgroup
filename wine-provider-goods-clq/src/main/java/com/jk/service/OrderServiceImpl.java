package com.jk.service;

import com.jk.mapper.OrderInfoMapper;
import com.jk.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/18 21:41
 * @Created by ${jmh}
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderInfoMapper  orderInfoMapper;


    @Override
    public long addOrder(OrderInfo orderInfo) {
        return orderInfoMapper.insertSelective(orderInfo);
    }
}
