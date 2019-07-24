package com.jk.service;

import com.jk.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:25
 * @Created by ${jmh}
 */
public interface GoodsServiceApi {

   @PostMapping("find")
    HashMap<String, Object> findchuizi(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize);
 @PostMapping("add")
    void add(Goods good);
    @GetMapping("find2")
    HashMap<String, Object> findchuizi2(  @RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize")  Integer pageSize);
/*
    @RequestMapping("queryDataList")
    List<EchaBean> queryDataList(ParamBean paramBean);
*/


/*    List<TreeBean> queryTreeNode(@RequestParam (value = "id") Integer id);*/

}
