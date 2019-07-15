package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "wine-provider-qwb")
public interface GoodsServiceFeign extends GoodsService{


}
