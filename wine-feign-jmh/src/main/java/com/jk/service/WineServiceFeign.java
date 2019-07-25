package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname WineServiceFeign
 * @Description TODO
 * @Date 2019/7/14 11:53
 * @Created by jmh
 */
@FeignClient(value = "springcloud-provider",fallback = WineServiceError.class)
public interface WineServiceFeign extends Coupon {
}
