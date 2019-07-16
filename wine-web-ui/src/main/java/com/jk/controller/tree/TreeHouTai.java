package com.jk.controller.tree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TreeHouTai {
    @RequestMapping("totree")
    public String toshow(){
        return "HouTai/tree";
    }
}
