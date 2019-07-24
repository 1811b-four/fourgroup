package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Classname DfMapper
 * @Description TODO
 * @Date 2019/7/10 20:14
 * @Created by dfp777
 */
@Mapper
public interface DfMapper {
    List<LinkedHashMap<String,Object>> findNews(@Param("start") Integer start, @Param("rows")Integer rows);

    Integer queryNewsCount();

    void addReceive(Goods good);

    List<LinkedHashMap<String, Object>> findNews2(  Integer start,@Param("rows")Integer rows);

/*    List<EchaBean> queryDataList(ParamBean paramBean);

    List<TreeBean> queryTreeNode(@Param("id") Integer id, @Param("pid") int pid);*/
}
