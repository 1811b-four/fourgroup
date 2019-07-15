package com.jk.Service;

import com.jk.Mapper.CarMapper;
import com.jk.service.shoppingcar.CarServicePublic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname CarServiceImpl
 * @Description TODO
 * @Date 2019-07-12 19:27
 * @Created by 谷凌杰
 */
@Service
public class CarServiceImpl implements CarServicePublic {
    @Autowired
    private CarMapper carMapper;
}
