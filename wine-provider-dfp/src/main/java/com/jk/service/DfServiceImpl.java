package com.jk.service;

import com.jk.mapper.DsMapper;
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
    private DsMapper newsMapper;

    @Override
    public HashMap<String, Object> findchuizi(Integer start, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer  total = newsMapper.queryNewsCount();
        List<LinkedHashMap<String,Object>> find = newsMapper.findNews(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",find);
        return hashMap;
    }
}
