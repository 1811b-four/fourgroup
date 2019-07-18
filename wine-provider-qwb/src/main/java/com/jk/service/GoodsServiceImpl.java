package com.jk.service;

import com.jk.mapper.GoodsMapper;
import com.jk.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public HashMap<String, Object> findGoods(Integer start, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer  total = goodsMapper.queryGoodsCount();
        List<LinkedHashMap<String,Object>> find = goodsMapper.findGoods(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",find);
        return hashMap;
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.addGoods(goods);
    }

    @Override
    public List<Goods> findGoods2() {
        return goodsMapper.findGoods2();
    }

   /* @Override
    public void del(Integer id) {
        newsMapper.del(id);
    }

    @Override
    public void addNews2(News news) {
        newsMapper.addNews2(news);
    }

    @Override
    public News findById(Integer id) {
        return newsMapper.findById(id);
    }

    @Override
    public void updateNews(News news) {
        newsMapper.updateNews(news);
    }*/
}
