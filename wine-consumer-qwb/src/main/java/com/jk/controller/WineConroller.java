package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.GoodsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class WineConroller {

    @Autowired
    private GoodsServiceFeign goodsServiceFeign;


    @RequestMapping("toindex")
    public String toindex(){

    return "index";
    }

    @RequestMapping("toshow")
    public String toshow(){

        return "show";
    }

    @GetMapping("findGoods")
    @ResponseBody
    public HashMap<String,Object> findGoods(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize){

        return goodsServiceFeign.findGoods(start,pageSize);
    }

    @RequestMapping("findaddDialog")
    public String findaddDialog(){

        return  "addDialog";
    }

    @PostMapping("addGoods")
    @ResponseBody
    public  void addGoods(Goods goods){
        goodsServiceFeign.addGoods(goods);
    }



}
