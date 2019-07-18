package com.jk.Mapper;

import com.jk.model.Goods;
import com.jk.model.shoppingcar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CarMapper
 * @Description TODO
 * @Date 2019-07-14 11:15
 * @Created by 谷凌杰
 */
public interface CarMapper {
    List<shoppingcar> query();

    void addNum(@Param("id") Integer id);

    void subNum(@Param("id")Integer id);

    void subLostNum(@Param("id")Integer id);

    void sddLostNum(@Param("id")Integer id);

    void LostNum(@Param("id")Integer id,@Param("sum")Integer sum);

    void del(@Param("split")Integer[] split);

    void deleteA(@Param("id")Integer id);

    Integer sumA();

    List<Goods> queryDetails();
}
