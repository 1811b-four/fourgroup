package com.jk.controller;

import com.jk.service.ServiceFeign;
import com.jk.utils.MenuTree;
import com.jk.utils.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping
public class TreeController {
    @Autowired
    private ServiceFeign serviceFeign;

    //同步
    @RequestMapping("getTreeAll")
    @ResponseBody
    public List<MenuTree> getTreeAll(){
        List<MenuTree> list = serviceFeign.getTreeAll();
        //将 数据库中返回的数据转换成easyui识别的数据格式
        list =  TreeNoteUtil.getFatherNode(list);
        return list;
    }

    //查询
    @GetMapping("findshangpin")
    @ResponseBody
    public HashMap<String,Object> findxinwen(@RequestParam(value = "start") Integer start, @RequestParam(value = "pageSize") Integer pageSize){

        return serviceFeign.findxinwen(start,pageSize);
    }

}
