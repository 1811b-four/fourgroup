package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

   /* @Override
    @GetMapping("del")
    public void del(@RequestParam Integer id) {
        newsService.del(id);
    }

    @Override
    @PostMapping("addNews2")
    public void addNews2(@RequestBody News news) {
        newsService.addNews2(news);
    }

    @Override
    @RequestMapping("findById")
    public News findById(@RequestParam Integer id) {
        return newsService.findById(id);
    }

    @Override
    @PostMapping("updateNews")
    public void updateNews(@RequestBody News news) {
        newsService.updateNews(news);
    }*/
}
