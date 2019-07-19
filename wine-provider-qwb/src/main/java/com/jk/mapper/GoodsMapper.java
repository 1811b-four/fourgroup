package com.jk.mapper;

import com.jk.model.Goods;
import com.jk.model.t_commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface GoodsMapper {

    
    Integer queryGoodsCount();

    List<LinkedHashMap<String, Object>> findGoods(Integer start, Integer rows);


    void addGoods(Goods goods);

    List<Goods> findGoods2();

    List<t_commodity> recommended();
}
