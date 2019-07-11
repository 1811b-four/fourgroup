package com.jk.service;

import com.jk.model.Goods;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:25
 * @Created by ${jmh}
 */
public interface GoodsServiceApi {


    @GetMapping("findGood")
    Goods findGood();
}
