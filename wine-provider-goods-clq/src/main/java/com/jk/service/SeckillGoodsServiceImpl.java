package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 16:59
 * @Created by ${jmh}
 */
@Service("seckillGoodsService")
public class SeckillGoodsServiceImpl  implements SeckillGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return goodsMapper.selectAllGoodes();
    }

    @Override
    public GoodsBo findSeckillGoodsBoByGoodsId(long goodsId) {
        return goodsMapper.findSeckillGoodsBoByGoodsId(goodsId);
    }
}
