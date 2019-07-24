package com.jk.controller;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;
import com.jk.service.SeckillGoodsService;
import com.jk.service.SeckillGoodsServiceApi;
import com.jk.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 16:56
 * @Created by ${jmh}
 */
@RestController
public class SeckillController implements SeckillGoodsServiceApi {


    @Autowired
    SeckillGoodsService  seckillGoodsService;

    @Autowired
    SeckillOrderService  seckillOrderService;






    @Override
    @RequestMapping("/getSeckillGoodsList")
    public List<GoodsBo> getSeckillGoodsList() {
        List<GoodsBo> seckillGoodsList = seckillGoodsService.getSeckillGoodsList();

        return seckillGoodsList;
    }

    @Override
    @RequestMapping("/findSeckillGoodsBoByGoodsId")
    public GoodsBo findSeckillGoodsBoByGoodsId(@RequestParam(value = "goodsId")long goodsId) {
        return   seckillGoodsService.findSeckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    @RequestMapping("/getSeckillOrderByUserIdGoodsId")
    public SeckillOrder getSeckillOrderByUserIdGoodsId(@RequestParam(value = "id") long id, @RequestParam(value = "goodsId") long goodsId) {
        return seckillOrderService.getSeckillOrderByUserIdGoodsId(id,goodsId);
    }

    @Override
    @GetMapping("/getSeckillResult")
    public long getSeckillResult(@RequestParam(value = "userId") long userId, @RequestParam(value = "goodsId") long goodsId) {
        return seckillOrderService.getSeckillResult(userId,goodsId);
    }


}
