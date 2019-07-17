package com.jk.service;

import com.jk.model.WineImg;
import com.jk.utils.MenuTree;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


public interface TreeService {
    @PostMapping("addNews2")
    void addNews2( WineImg jiu);
    //同步
    @RequestMapping("getTreeAll")
    List<MenuTree> getTreeAll();
    //查询
    @GetMapping("findxinwen")
    HashMap<String,Object> findxinwen(@RequestParam(value = "start")Integer start, @RequestParam(value = "pageSize") Integer pageSize);

}
