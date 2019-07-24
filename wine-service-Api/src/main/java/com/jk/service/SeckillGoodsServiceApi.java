package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 16:28
 * @Created by ${jmh}
 */
public interface SeckillGoodsServiceApi {

    @RequestMapping("/getSeckillGoodsList")
    List<GoodsBo> getSeckillGoodsList();

    @RequestMapping("/findSeckillGoodsBoByGoodsId")
    GoodsBo findSeckillGoodsBoByGoodsId(@RequestParam(value = "goodsId") long goodsId);

    @RequestMapping("/getSeckillOrderByUserIdGoodsId")
    SeckillOrder getSeckillOrderByUserIdGoodsId(@RequestParam(value = "userId") long userId, @RequestParam(value = "goodsId") long goodsId);


    @GetMapping("/getSeckillResult")
    long getSeckillResult(@RequestParam(value = "userId") long userId, @RequestParam(value = "goodsId") long goodsId);
}
