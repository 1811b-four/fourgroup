package com.jk.controller;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;
import com.jk.service.SecGoodsService;
import com.jk.service.SeckillServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/24 10:31
 * @Created by ${jmh}
 */
@RestController
public class SecGoodsController implements SeckillServiceApi {



    @Autowired
    private SecGoodsService secGoodsService;


    @Override
    @RequestMapping("/getSeckillGoodsList")
    public List<GoodsBo> getSeckillGoodsList() {
        return secGoodsService.getSeckillGoodsList();
    }

    @Override
    @RequestMapping("/findSeckillGoodsBoByGoodsId")
    public GoodsBo findSeckillGoodsBoByGoodsId(@RequestParam(value = "goodsId")long goodsId) {
        return   secGoodsService.findSeckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    @RequestMapping("/getSeckillOrderByUserIdGoodsId")
    public SeckillOrder getSeckillOrderByUserIdGoodsId(@RequestParam(value = "userId") long userId,@RequestParam("goodsId") long goodsId) {
        return secGoodsService.getSeckillOrderByUserIdGoodsId(userId,goodsId);
    }
}
