package com.jk.dao;

import com.jk.model.Order;
import com.jk.model.shoppingcar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    shoppingcar queryList(String id);

    void addOrders(Order order);
}
