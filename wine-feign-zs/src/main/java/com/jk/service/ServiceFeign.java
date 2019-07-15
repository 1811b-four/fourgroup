package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "springcloud-pre")
public interface ServiceFeign extends TreeService{
}
