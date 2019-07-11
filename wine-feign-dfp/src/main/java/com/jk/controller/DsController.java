package com.jk.controller;

import com.jk.service.DsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @Classname DsController
 * @Description TODO
 * @Date 2019/7/10 8:52
 * @Created by dfp777
 */
public class DsController {
    @Autowired
    private DsService DsService;

    @GetMapping("findchuizi")
    public HashMap<String,Object> findNews(@RequestParam Integer start, @RequestParam Integer pageSize){

        return DsService.findchuizi(start,pageSize);
    }

}
