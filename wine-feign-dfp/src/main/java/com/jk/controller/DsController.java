package com.jk.controller;

import com.jk.model.Goods;
import com.jk.service.DsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Classname DsController
 * @Description TODO
 * @Date 2019/7/10 8:52
 * @Created by dfp777
 */
@RestController
public class DsController {
    @Autowired
    private DsService DsService;

    @GetMapping("find")
    public HashMap<String,Object> findNews(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize){

        return DsService.findchuizi(start,pageSize);
    }

    @PostMapping("add")
    public void add(Goods good){
        DsService.add(good);
    }


}
