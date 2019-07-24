package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 16:27
 * @Created by ${jmh}
 */
@FeignClient(value = "wine-provider-goods",fallback = SeckillGoodsServiceError.class)
public interface SeckillGoodsServiceFeign extends SeckillGoodsServiceApi{
}
