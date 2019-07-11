package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.GoodsServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
         good.setGoodId(521);
         good.setGoodName("买个黑天鹅");
         good.setGoodPrice(BigDecimal.valueOf(1000.90));
         good.setGoodDate("2019-07-08");

        return good;
    }
}
