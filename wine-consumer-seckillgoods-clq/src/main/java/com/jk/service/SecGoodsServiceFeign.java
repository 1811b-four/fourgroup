package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 16:27
 * @Created by ${jmh}
 */
@FeignClient(value = "wine-provider-seckillgoods-clq",fallback = SecGoodsServiceError.class)
public interface SecGoodsServiceFeign extends SeckillServiceApi{
}
