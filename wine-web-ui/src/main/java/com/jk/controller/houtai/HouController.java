package com.jk.controller.houtai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname HouController
 * @Description TODO
 * @Date 2019/7/16 9:47
 * @Created by dfp777
 */
@Controller
public class HouController {
    @RequestMapping("show")
    public String toindex(){
       return "houtai/show1";
}
    @RequestMapping("show2")
    public String toindex2(){
        return "houtai/show2";
    }
}
