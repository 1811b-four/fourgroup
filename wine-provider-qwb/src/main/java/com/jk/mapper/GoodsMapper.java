package com.jk.mapper;

import com.jk.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface GoodsMapper {

    
    Integer queryGoodsCount();

    List<LinkedHashMap<String, Object>> findGoods(Integer start, Integer rows);


    void addGoods(Goods goods);
}
