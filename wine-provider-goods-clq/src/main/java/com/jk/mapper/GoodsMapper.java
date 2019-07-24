package com.jk.mapper;

import com.jk.bo.GoodsBo;
import com.jk.model.Goods;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<GoodsBo> selectAllGoodes();

    GoodsBo findSeckillGoodsBoByGoodsId(long goodsId);

    int updateStock(Long id);
}