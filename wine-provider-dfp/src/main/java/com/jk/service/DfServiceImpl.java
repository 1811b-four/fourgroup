package com.jk.service;

import com.jk.mapper.DfMapper;
import com.jk.model.EchaBean;
import com.jk.model.Goods;
import com.jk.model.ParamBean;
import com.jk.model.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Classname DfServiceImpl
 * @Description TODO
 * @Date 2019/7/10 20:08
 * @Created by dfp777
 */
@Service
public class DfServiceImpl  implements  GoodsServiceApi{
    @Autowired
    private DfMapper newsMapper;

    @Override
    public HashMap<String, Object> findchuizi(Integer start, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer  total = newsMapper.queryNewsCount();
        List<LinkedHashMap<String,Object>> find = newsMapper.findNews(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",find);
        return hashMap;
    }

    @Override
    public void add(Goods good) {
        newsMapper.addReceive(good);
    }
/*
    @Override
    public List<EchaBean> queryDataList(ParamBean paramBean) {
        return newsMapper.queryDataList(paramBean);
    }


    @Override
    public List<TreeBean> queryTreeNode(Integer id) {
        String name = "pid";
        int pid = Integer.parseInt(name);
        return newsMapper.queryTreeNode(id,pid);
    }*/





}
