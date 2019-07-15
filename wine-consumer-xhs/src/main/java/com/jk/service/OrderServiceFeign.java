package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "wine-provider-xhs")
public interface OrderServiceFeign extends OrderServiceApi {

}
