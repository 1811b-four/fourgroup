package com.jk.Controller;

import com.jk.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname Controller
 * @Description TODO
 * @Date 2019-07-12 19:20
 * @Created by 谷凌杰
 */
@RestController
public class CarController1 {
    @Autowired
    private CarService carService;



}
