package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "wine-provider-wy",fallback =TestServiceError.class)
public interface TestService extends WyTestService{
}
