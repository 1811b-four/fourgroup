package com.jk.service.shoppingcar;

import com.jk.model.shoppingcar;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Classname CarServicePublic
 * @Description TODO
 * @Date 2019-07-14 11:05
 * @Created by 谷凌杰
 */
public interface CarServicePublic {

    @GetMapping("query")
    List<shoppingcar> query();
}
