package com.jk.controller;

import com.jk.model.EchaBean;
import com.jk.model.Goods;
import com.jk.model.ParamBean;
import com.jk.model.TreeBean;
import com.jk.service.DsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @Classname DsController
 * @Description TODO
 * @Date 2019/7/10 8:52
 * @Created by dfp777
 */
@RestController
public class DsController {
    @Autowired
    private DsService DsService;



    @GetMapping("find")
    public HashMap<String,Object> findNews(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize){
        System.out.println("dawodjkadladkwadkaldkawldakdlakdlawklmk");
        return DsService.findchuizi(start,pageSize);
    }

    @PostMapping("add")
    public void add(Goods good){
        DsService.add(good);
    }


    //修改回显
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam Integer id, Model model, ModelAndView mv){
        /*News news=  newsServiceFeign.findById(id);
        model.addAttribute("news",news);*/
        mv.setViewName("update");
        return mv;
    }



  /*  @RequestMapping("queryDataList")
    @ResponseBody
    public List<EchaBean> queryDataList(ParamBean paramBean){
        List<EchaBean> list = DsService.queryDataList(paramBean);
        return list;
    }*/

   /* //同步树
    @RequestMapping("getTree")
    @ResponseBody
    public List<TreeBean> getTree(){
        Integer id = 0;
        List<TreeBean> treeNode = treeNode(id);
        return treeNode;
    }

    private List<TreeBean> treeNode(@RequestParam (value = "id") Integer id) {
        //根据id查询子节点
        List<TreeBean>  treeList = DsService.queryTreeNode(id);
        //for循环得到每一个id值  作为下一次查询pid的条件
        for (TreeBean treeBean : treeList) {
            Integer id2 = treeBean.getId();
            List<TreeBean> treeNode = treeNode(id2);
            treeBean.setNodes(treeNode);
        }
        return treeList;
    }


   */
}
