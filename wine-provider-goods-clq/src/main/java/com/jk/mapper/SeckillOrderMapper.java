package com.jk.mapper;

import com.jk.model.OrderInfo;
import com.jk.model.SeckillOrder;
import org.apache.ibatis.annotations.Param;

public interface SeckillOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);

    SeckillOrder getSeckillOrderByUserIdGoodsId(@Param("userId") long userId, @Param("goodsId") long goodsId);

    long addOrder(OrderInfo orderInfo);
}