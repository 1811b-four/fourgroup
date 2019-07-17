package com.jk.service;

import com.jk.mapper.TreeMapper;
import com.jk.model.t_commodity;
import com.jk.utils.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TreeServiceImpl {
    @Autowired
    private TreeMapper treeMapper;

    //同步
    public List<MenuTree> getTreeAll() {
        return treeMapper.getTreeAll();
    }

    //查询
    public HashMap<String, Object> findxinwen(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = treeMapper.findRoadTotal();
        //分页
        int start = (page-1)*rows;
        List<t_commodity> list = treeMapper.findRoadPage(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return  hashMap;
    }
}
