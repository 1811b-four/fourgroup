package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.DfServiceImpl;
import com.jk.service.GoodsServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Classname DfController
 * @Description TODO
 * @Date 2019/7/10 20:03
 * @Created by dfp777
 */
@RestController
public class DfController implements GoodsServiceApi {
    @Autowired
    private DfServiceImpl newsService;

    @Override
    @GetMapping("find")
    public HashMap<String, Object> findchuizi(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize) {
        return newsService.findchuizi(start,pageSize);
    }

    @Override
    @PostMapping("add")
    public void add(Goods good){
        newsService.add(good);
    }
}
