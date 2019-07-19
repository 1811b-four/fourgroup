package com.jk.controller;

import com.jk.model.Goods;
import com.jk.model.t_commodity;
import com.jk.service.GoodsServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    //商品秒杀展示
    @GetMapping("findGoods2")
    public String findGoods2(Model model){
        List<Goods> goods= goodsServiceFeign.findGoods2();
        model.addAttribute("goodsList",goods);
        return "list.html";

    }

    //爆款推荐展示Recommended
    @GetMapping("recommended")
    public String recommended(Model model){
        List<t_commodity> recommended= goodsServiceFeign.recommended();
        model.addAttribute("goodsList",recommended);
        return "list2.html";

    }


}
