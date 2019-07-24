package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.model.OrderInfo;
import com.jk.model.SeckillOrder;
import com.jk.model.User;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/18 11:12
 * @Created by ${jmh}
 */

public interface SeckillOrderService {
    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId);

    OrderInfo insert(User user, GoodsBo goods);

    long getSeckillResult(long userId, long goodsId);
}
