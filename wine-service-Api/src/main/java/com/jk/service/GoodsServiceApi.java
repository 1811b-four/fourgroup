package com.jk.service;

<<<<<<< .merge_file_a11624
import com.jk.model.EchaBean;
import com.jk.model.Goods;
import com.jk.model.ParamBean;
import com.jk.model.TreeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
=======
import com.jk.model.Goods;
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> .merge_file_a16924

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:25
 * @Created by ${jmh}
 */
public interface GoodsServiceApi {

<<<<<<< .merge_file_a11624
   @GetMapping("find")
    HashMap<String, Object> findchuizi(@RequestParam (value = "start") Integer start, @RequestParam (value = "pageSize") Integer pageSize);
    @PostMapping("add")
    void add(Goods good);
/*
    @RequestMapping("queryDataList")
    List<EchaBean> queryDataList(ParamBean paramBean);
*/


/*    List<TreeBean> queryTreeNode(@RequestParam (value = "id") Integer id);*/

=======

    @GetMapping("findGood")
    Goods findGood();
>>>>>>> .merge_file_a16924
}
