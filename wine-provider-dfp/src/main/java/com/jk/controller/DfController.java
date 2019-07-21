package com.jk.controller;

import com.jk.model.EchaBean;
import com.jk.model.Goods;
import com.jk.model.ParamBean;
import com.jk.model.TreeBean;
import com.jk.service.DfServiceImpl;
import com.jk.service.GoodsServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname DfController
 * @Description TODO
 * @Date 2019/7/10 20:03
 * @Created by dfp777
 */
@RestController
public class DfController implements GoodsServiceApi {
    @Autowired
    private DfServiceImpl newsService;

    @Override
    @GetMapping("find")
    public HashMap<String, Object> findchuizi(@RequestParam(value = "start") Integer start, @RequestParam(value = "pageSize") Integer pageSize) {
        return newsService.findchuizi(start, pageSize);
    }

    @Override
    @PostMapping("add")
    public void add(Goods good) {
        newsService.add(good);
    }

    @Override
    @GetMapping("find2")
    public HashMap<String, Object> findchuizi2(@RequestParam(value = "start") Integer start, @RequestParam(value = "pageSize") Integer pageSize) {
        return newsService.findchuizi2(start, pageSize);
    }
/*

    @RequestMapping("queryDataList")
    @ResponseBody
    public List<EchaBean> queryDataList(ParamBean paramBean) {
        List<EchaBean> list = newsService.queryDataList(paramBean);
        return list;
    }
*/


/*
    @Override
    public List<TreeBean> queryTreeNode(@RequestParam(value = "id") Integer id) {
        //根据id查询子节点
        List<TreeBean>  treeList = newsService.queryTreeNode(id);
        //for循环得到每一个id值  作为下一次查询pid的条件
        return null;

    }*/

    }
