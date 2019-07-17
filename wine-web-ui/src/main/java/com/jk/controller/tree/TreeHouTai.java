package com.jk.controller.tree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TreeHouTai {
    //树
    @RequestMapping("totree")
    public String toshow(){
        return "HouTai/tree";
    }
    //查询商品
    @RequestMapping("tosp")
    public String tosp(){
        return "HouTai/findsp";
    }
}
