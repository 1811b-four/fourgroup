package com.jk.Service;

import com.jk.model.shoppingcar;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname CarServiceImpl
 * @Description TODO
 * @Date 2019-07-14 11:04
 * @Created by 谷凌杰
 */
@RequestMapping("/error")
@Component
public class CarServiceImpl implements CarService {
    @Override
    public List<shoppingcar> query() {
        return null;
    }
}
