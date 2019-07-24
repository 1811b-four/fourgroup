package com.jk.controller.xhs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("toConfirmOrder")
    public String toConfirmOrder(Integer[] strIds , ModelMap map){
        //List<shoppingcar> goodList = orderServiceApi.queryGoodsList(strIds);
        map.put("strIds",strIds);
        return "xhs/confirmOrder";
    }
}
