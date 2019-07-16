package com.jk.service;

import com.jk.utils.MenuTree;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


public interface TreeService {
    //同步
    @RequestMapping("getTreeAll")
    List<MenuTree> getTreeAll();
    //查询
    @GetMapping("findxinwen")
    HashMap<String,Object> findxinwen(@RequestParam(value = "start")Integer start, @RequestParam(value = "pageSize") Integer pageSize);

}
