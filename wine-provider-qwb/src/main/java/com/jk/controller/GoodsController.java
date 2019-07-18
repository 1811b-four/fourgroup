package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class GoodsController implements GoodsService {

    @Autowired
    private GoodsService goodsService;






    @Override
    @GetMapping("findGoods")
    public HashMap<String,Object> findGoods(@RequestParam (value = "start")Integer start, @RequestParam (value = "pageSize")Integer pageSize){
        return goodsService.findGoods(start,pageSize);
    }

    @Override
    @PostMapping("addGoods")
    public void addGoods(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
    }

    @Override
    @GetMapping("findGoods2")
    public List<Goods> findGoods2() {
        return goodsService.findGoods2();
    }


}
