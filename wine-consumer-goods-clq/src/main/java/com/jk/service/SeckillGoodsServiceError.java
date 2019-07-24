package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/15 20:40
 * @Created by ${jmh}
 */
@RequestMapping("/error")
@Component
public class SeckillGoodsServiceError implements SeckillGoodsServiceFeign
{
    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return null;
    }

    @Override
    public GoodsBo findSeckillGoodsBoByGoodsId(long goodsId) {
        return null;
    }

    @Override
    public SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId) {
        return null;
    }

    @Override
    public long getSeckillResult(long userId, long goodsId) {
        return 0;
    }


}
