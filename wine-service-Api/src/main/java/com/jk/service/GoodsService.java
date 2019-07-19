package com.jk.service;

import com.jk.model.Goods;
import com.jk.model.t_commodity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {

    @GetMapping("findGoods")
    HashMap<String, Object> findGoods(@RequestParam(value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize);

    @PostMapping("addGoods")
    void addGoods(@RequestBody Goods goods);
    @GetMapping("findGoods2")
    List<Goods> findGoods2();
    @GetMapping("recommended")
    List<t_commodity> recommended();
}
