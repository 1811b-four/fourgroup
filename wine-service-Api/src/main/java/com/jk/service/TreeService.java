package com.jk.service;

import com.jk.model.WineImg;
import com.jk.utils.MenuTree;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


public interface TreeService {

    //同步
    @RequestMapping("getTreeAll")
    List<MenuTree> getTreeAll();
    //查询
    @GetMapping("findshangpin")
    HashMap<String,Object> findxinwen(@RequestParam(value = "start")Integer start, @RequestParam(value = "pageSize") Integer pageSize);
    //删除
    @GetMapping("del")
    void del(@RequestParam(value = "id")Integer id);
}
