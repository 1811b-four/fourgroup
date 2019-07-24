package com.jk.controller;

import com.jk.bo.GoodsBo;

import com.jk.redis.RedisKey;

import com.jk.service.GoodsServiceFeign;
import com.jk.service.SeckillGoodsServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/8 21:12
 * @Created by ${jmh}
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    /*     @Autowired
         private GoodsServiceFeign  goodsServiceFeign;



         @GetMapping("findGood")
          public Goods   findGood(){
             return goodsServiceFeign.findGood();
         }*/
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SeckillGoodsServiceFeign seckillGoodsServiceFeign;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "/goods_list", produces = "text/html")
    @ResponseBody
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {

        String html = (String) redisTemplate.opsForValue().get(RedisKey.SECKILL_LIST);
        if (!StringUtils.isEmpty(html)) {
            return html;
        }
        List<GoodsBo> goodsList = seckillGoodsServiceFeign.getSeckillGoodsList();
        model.addAttribute("goodsList", goodsList);
        //因为在thymeleaf.spring5的API中把大部分的功能移到了IWebContext下面,用来区分边界。剔除了ApplicationContext 过多的依赖，现在thymeleaf渲染不再过多依赖spring容器
        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());

        String html2 = thymeleafViewResolver.getTemplateEngine().process("/goods_list", ctx);

        redisTemplate.opsForValue().set(RedisKey.SECKILL_LIST,html2);

        redisTemplate.expire(RedisKey.SECKILL_LIST,30, TimeUnit.SECONDS);


        return html2;
    }

    @RequestMapping(value = "/goods_detail", produces = "text/html")
    @ResponseBody
    public String detail2(Model model, @RequestParam(value = "goodsId") long goodsId, HttpServletRequest request, HttpServletResponse response) {

      /*  User user = new User();
        user.setId(100);
        user.setUserName("clq");
        user.setLastLoginDate(new Date());
        User user1 = (User) redisTemplate.opsForValue().get(RedisKey.USER_ID + "_" + RedisKey.USER_NAME);
        if (user1 == null) {
            redisTemplate.opsForValue().set(RedisKey.USER_ID + "_" + RedisKey.USER_NAME, user1);
        }
        model.addAttribute("user", user1);*/

        //取缓存
        String html = (String) redisTemplate.opsForValue().get(RedisKey.SECKILL_DETAIL+"_"+goodsId);

        if (!StringUtils.isEmpty(html)) {
            return html;
        }

        GoodsBo goods = seckillGoodsServiceFeign.findSeckillGoodsBoByGoodsId(goodsId);

        if (goods == null) {
            return "没有找到该页面";
        } else {

            model.addAttribute("goods", goods);

            long startAt = goods.getStartDate().getTime();
            long endAt = goods.getEndDate().getTime();
            long now = System.currentTimeMillis();

            int miaoshaStatus = 0;
            int remainSeconds = 0;

            if (now < startAt) {  //秒杀还没开始，倒计时
                miaoshaStatus = 0;
                remainSeconds = (int) ((startAt - now) / 1000);
            } else if (now > endAt) { //秒杀已经结束
                miaoshaStatus = 2;
                remainSeconds = -1;
            } else {
                miaoshaStatus = 1;
                remainSeconds = 0;

            }
            model.addAttribute("seckillStatus", miaoshaStatus);
            model.addAttribute("remainSeconds", remainSeconds);

            //因为在thymeleaf.spring5的API中把大部分的功能移到了IWebContext下面,用来区分边界。剔除了ApplicationContext 过多的依赖，现在thymeleaf渲染不再过多依赖spring容器
            WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());

            String html2 = thymeleafViewResolver.getTemplateEngine().process("goods_detail", ctx);

                redisTemplate.opsForValue().set(RedisKey.SECKILL_DETAIL+"_"+goodsId, html2);

                redisTemplate.expire(RedisKey.SECKILL_DETAIL+"_"+goodsId,30, TimeUnit.SECONDS);

            return html2;
        }
    }













    }