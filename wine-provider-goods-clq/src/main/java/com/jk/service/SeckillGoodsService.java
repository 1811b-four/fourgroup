package com.jk.service;

import com.jk.bo.GoodsBo;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 16:57
 * @Created by ${jmh}
 */
public interface SeckillGoodsService {



    List<GoodsBo> getSeckillGoodsList();

    GoodsBo findSeckillGoodsBoByGoodsId(long goodsId);



}
