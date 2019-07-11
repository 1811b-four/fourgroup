package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:14
 * @Created by ${jmh}
 */
@FeignClient(value = "wine-provider-goods",fallback = GoodsServiceError.class)
public interface GoodsServiceFeign extends GoodsServiceApi{
}
