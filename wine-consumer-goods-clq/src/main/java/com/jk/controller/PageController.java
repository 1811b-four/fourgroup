package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/12 11:56
 * @Created by ${jmh}
 */
@Controller
@RequestMapping("/page")
public class PageController {


           @RequestMapping("login")
           public ModelAndView  loginpage(ModelAndView mv){

               mv.setViewName("login");

               return mv;
           }

    @RequestMapping("goodsList")
    public ModelAndView  goodsList(ModelAndView mv){

        mv.setViewName("goods_list");

        return mv;
    }

    public  String  findDemo(){

        StringBuffer stringBuffer = new StringBuffer();

        StringBuffer str = stringBuffer.append("eee");

        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder str1 = stringBuilder.append("fff");



        return null;
    }







}
