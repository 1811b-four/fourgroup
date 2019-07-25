package com.jk.Service;

import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname CarServicePublic
 * @Description TODO
 * @Date 2019-07-12 19:28
 * @Created by 谷凌杰
 */
@FeignClient(value = "springcloud-shoppingcar",fallback =CarServiceImpl.class )
public interface CarService extends CarServicePublic {

}
