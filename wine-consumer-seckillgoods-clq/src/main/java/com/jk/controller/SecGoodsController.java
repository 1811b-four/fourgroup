package com.jk.controller;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;
import com.jk.model.User;
import com.jk.redis.RedisKey;
import com.jk.redis.SeckillKey;


import com.jk.result.CodeMsg;
import com.jk.result.Result;
import com.jk.service.SecGoodsServiceFeign;

import com.jk.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/24 10:21
 * @Created by ${jmh}
 */
@Controller
@RequestMapping("/goods")
public class SecGoodsController {


    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SecGoodsServiceFeign secGoodsServiceFeign;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @RequestMapping(value = "/goods_list", produces = "text/html")
    @ResponseBody
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {

        String html = (String) redisTemplate.opsForValue().get(RedisKey.SECKILL_LIST);
        if (!StringUtils.isEmpty(html)) {
            return html;
        }
        List<GoodsBo> goodsList = secGoodsServiceFeign.getSeckillGoodsList();

        model.addAttribute("goodsList", goodsList);

        //因为在thymeleaf.spring5的API中把大部分的功能移到了IWebContext下面,用来区分边界。剔除了ApplicationContext 过多的依赖，现在thymeleaf渲染不再过多依赖spring容器
        WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale(), model.asMap());

        String html2 = thymeleafViewResolver.getTemplateEngine().process("/goods_list", ctx);

        redisTemplate.opsForValue().set(RedisKey.SECKILL_LIST,html2);

        redisTemplate.expire(RedisKey.SECKILL_LIST,300, TimeUnit.SECONDS);


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

        GoodsBo goods = secGoodsServiceFeign.findSeckillGoodsBoByGoodsId(goodsId);

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

            redisTemplate.opsForValue().set(RedisKey.SECKILLGOODS_STOCK+"_"+goods.getId(),goods.getStockCount());

            redisTemplate.expire(RedisKey.SECKILL_DETAIL+"_"+goodsId,300, TimeUnit.SECONDS);

            return html2;
        }
    }



    @RequestMapping(value = "/path", method = RequestMethod.GET)
    @ResponseBody
    public String getMiaoshaPath(HttpServletRequest request,
                                 @RequestParam("goodsId") long goodsId) {
        User user1 = new User();

        user1.setId(100l);

        user1.setUserName("clq");

        String  path =  MD5Util.md5(UUID.randomUUID()+"123456");



        redisTemplate.opsForValue().set(SeckillKey.SECKILL_PATH+"_"+user1.getId()+"_"+goodsId,path);

        redisTemplate.expire(SeckillKey.SECKILL_PATH+"_"+user1.getId()+"_"+goodsId,30,TimeUnit.SECONDS);

        return path;
    }


    @RequestMapping(value = "/{path}/seckill", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> list(Model model,
                                @RequestParam("goodsId") long goodsId,
                                @PathVariable("path") String path,
                                HttpServletRequest request) {

        User user1 = new User();

        user1.setId(100l);

        user1.setUserName("clq");
        //验证path
        String pathOld = (String) redisTemplate.opsForValue().get(SeckillKey.SECKILL_PATH + "_" + user1.getId() + "_" + goodsId);
        boolean check = path.equals(pathOld);
        if (!check) {
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        //内存标记，减少redis访问
        /*boolean over = localOverMap.get(goodsId);
        if (over) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }*//**/
        //预减库存
        Long stock = redisTemplate.opsForValue().decrement(RedisKey.SECKILLGOODS_STOCK + "_" + goodsId);
        if (stock < 0) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }

        //判断是否已经秒杀到了
        SeckillOrder order =  secGoodsServiceFeign.getSeckillOrderByUserIdGoodsId(user1.getId(), goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_MIAOSHA);
        }

        /*SeckillMessage mm = new SeckillMessage();
        mm.setUser(user1);
        mm.setGoodsId(goodsId);
        mqSender.sendSeckillMessager(mm);*/
        return Result.success(0);//排队中
    }


    /**
     * 客户端轮询查询是否下单成功
     * orderId：成功
     * -1：秒杀失败
     * 0： 排队中
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public Result<Long> miaoshaResult(@RequestParam("goodsId") long goodsId, HttpServletRequest request) {
        User user1 = new User();

        user1.setId(100l);

        user1.setUserName("clq");

        long result = getSeckillResult(user1.getId(), goodsId);

        return Result.success(result);
    }


        public   long  getSeckillResult(long userId,long goodsId){
            SeckillOrder order = secGoodsServiceFeign.getSeckillOrderByUserIdGoodsId(userId, goodsId);
            if(order != null) {//秒杀成功
                return order.getOrderId();
            }else {
                boolean isOver = getGoodsOver(goodsId);
                if(isOver) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }


    /*
     * 秒杀商品结束标记
     * */
    private void setGoodsOver(Long goodsId) {
        redisTemplate.opsForValue().set(SeckillKey.IS_GOODS_OVER+"_"+goodsId,true);
        redisTemplate.expire(SeckillKey.IS_GOODS_OVER+"_"+goodsId,60,TimeUnit.SECONDS);
    }

    /*
     * 查看秒杀商品是否已经结束
     * */
    private boolean getGoodsOver(long goodsId) {
        String realKey = (String) redisTemplate.opsForValue().get(SeckillKey.IS_GOODS_OVER + "_" + goodsId);
        Boolean flag = redisTemplate.hasKey(realKey);
        return flag;
    }




















}
