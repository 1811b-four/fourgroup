package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

<<<<<<< HEAD

@FeignClient(value = "springcloud-pre", fallback = NewsServiceError.class)
public interface ServiceFeign extends TreeService{
=======
@FeignClient(value = "springcloud-pre", fallback = NewsServiceError.class)
public interface ServiceFeign extends JiuService{

>>>>>>> e2e918422d16336b0724d5db9e6013a108ab0a07
}
