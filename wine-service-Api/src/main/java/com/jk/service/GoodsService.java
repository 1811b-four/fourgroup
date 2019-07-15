package com.jk.service;

import com.jk.model.Goods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public interface GoodsService {

    @GetMapping("findGoods")
    HashMap<String, Object> findGoods(@RequestParam(value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize);

    @PostMapping("addGoods")
    void addGoods(@RequestBody Goods goods);
}
