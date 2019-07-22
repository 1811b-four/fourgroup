package com.jk.controller.elastic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/21 16:33
 * @Created by ${jmh}
 */
@Controller
public class EsShowController {


        //toElastic
        @RequestMapping("toElastic")
        public  ModelAndView  toElastic(ModelAndView mv){
            mv.setViewName("elasticsearch/ElasticShow");
            return mv;
        }






}
