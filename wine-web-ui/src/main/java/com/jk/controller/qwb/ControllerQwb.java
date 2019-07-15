package com.jk.controller.qwb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerQwb {


    @RequestMapping("toindex2")
    public String toindex(){

        return "qwb/index";
    }

    @RequestMapping("toshow")
    public String toshow(){

        return "qwb/show";
    }

}
