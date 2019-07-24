package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/24 10:32
 * @Created by ${jmh}
 */
public interface SecGoodsService {
    List<GoodsBo> getSeckillGoodsList();

    GoodsBo findSeckillGoodsBoByGoodsId(long goodsId);

    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId);

}
