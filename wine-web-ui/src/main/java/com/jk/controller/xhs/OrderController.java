package com.jk.controller.xhs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("toConfirmOrder")
    public String toConfirmOrder(Integer[] strIds , ModelMap map){
        //List<shoppingcar> goodList = orderServiceApi.queryGoodsList(strIds);
        ArrayList<Integer> liststr=new ArrayList<Integer>();
        for(int i=0;i<strIds.length;i++){
            liststr.add(strIds[i]);
        }
        map.put("liststr",liststr);
        return "xhs/confirmOrder";
    }
}
