package com.jk.controller;

import com.jk.service.ServiceFeign;
import com.jk.utils.MenuTree;
import com.jk.utils.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreeController {
    @Autowired
    private ServiceFeign serviceFeign;

    @RequestMapping("getTreeAll")
    public @ResponseBody
    List<MenuTree> getTreeAll(){

        List<MenuTree> list = serviceFeign.getTreeAll();

        //将 数据库中返回的数据转换成easyui识别的数据格式
        list =  TreeNoteUtil.getFatherNode(list);

        return list;
    }
}
