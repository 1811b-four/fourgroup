package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.GoodsServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:17
 * @Created by ${jmh}
 */
@RestController
public class GoodsController implements GoodsServiceApi {
    @Override
    @GetMapping("findGood")
    public Goods findGood() {

        Goods good = new Goods();
         good.setId(1229L);
         good.setGoodsName("买个黑天鹅");
         good.setGoodsPrice(BigDecimal.valueOf(1000.90));
         good.setCreateDate(new Date());

        return good;
    }
}
