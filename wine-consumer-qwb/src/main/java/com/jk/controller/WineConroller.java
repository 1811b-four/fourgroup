package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.GoodsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class WineConroller {

    @Autowired
    private GoodsServiceFeign goodsServiceFeign;




    @GetMapping("findGoods")
    @ResponseBody
    public HashMap<String,Object> findGoods(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize){

        return goodsServiceFeign.findGoods(start,pageSize);
    }



    @PostMapping("addGoods")
    @ResponseBody
    public  void addGoods(Goods goods){
        goodsServiceFeign.addGoods(goods);
    }

    @GetMapping("findGoods2")
    public String findGoods2(Model model){
        List<Goods> goods= goodsServiceFeign.findGoods2();
        model.addAttribute("goodsList",goods);
        return "list.html";

    }

    @RequestMapping("list")
    public String list(){

        return  "list";
    }

}
