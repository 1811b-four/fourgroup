package com.jk.controller;

import com.jk.model.WineImg;
import com.jk.service.TreeService;
import com.jk.service.TreeServiceImpl;
import com.jk.utils.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TreePro implements TreeService {
    @Autowired
    private TreeServiceImpl treeServiceImpl;

    //同步树
    @Override
    @RequestMapping("getTreeAll")
    public List<MenuTree> getTreeAll() {
        return treeServiceImpl.getTreeAll();
    }


    //查询
    @Override
    @GetMapping("findshangpin")
    public HashMap<String,Object> findxinwen(@RequestParam(value = "start") Integer start, @RequestParam(value = "pageSize") Integer pageSize){

        return treeServiceImpl.findxinwen(start,pageSize);
    }

}
