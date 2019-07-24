package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.mapper.SecGoodsMapper;
import com.jk.model.SeckillOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/24 10:32
 * @Created by ${jmh}
 */
@Service("secGoodsService")
public class SecGoodsServiceImpl implements SecGoodsService {

    @Autowired
    private  SecGoodsMapper SecGoodsMapper;


    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        List<GoodsBo> goodsBos = SecGoodsMapper.seclectAllGoods();
        return goodsBos;
    }

    @Override
    public GoodsBo findSeckillGoodsBoByGoodsId(long goodsId) {
        return SecGoodsMapper.findSeckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    public SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId) {
        return SecGoodsMapper.getSeckillOrderByUserIdGoodsId(userId,goodsId);
    }
}
