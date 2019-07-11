package com.jk.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Classname DsMapper
 * @Description TODO
 * @Date 2019/7/10 20:14
 * @Created by dfp777
 */
@Mapper
public interface DsMapper {
    List<LinkedHashMap<String,Object>> findNews(Integer start, Integer rows);

    Integer queryNewsCount();
}
