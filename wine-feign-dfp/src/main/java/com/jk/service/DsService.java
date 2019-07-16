package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.HashMap;

/**
 * @Classname DsService
 * @Description TODO
 * @Date 2019/7/10 8:53
 * @Created by dfp777
 */
@FeignClient(value = "springcloud-order")
public interface DsService  extends GoodsServiceApi {

}
