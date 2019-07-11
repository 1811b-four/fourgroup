package com.jk.service;

import com.jk.model.Goods;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:14
 * @Created by ${jmh}
 */
@RequestMapping("/error")
@Component
public class GoodsServiceError implements GoodsServiceFeign{
    @Override
    public Goods findGood() {
        return null;
    }
}
