package com.jk.mapper;

import com.jk.model.t_commodity;
import com.jk.utils.MenuTree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TreeMapper {
    //同步树
    @Select("select * from menutree ")
    List<MenuTree> getTreeAll();
//查询
    Integer findRoadTotal();

    List<t_commodity> findRoadPage(@Param(value = "start") Integer start, @Param(value = "rows") Integer rows);
//删除
    void del(@Param(value = "id")Integer id);
}
