package com.jk.controller;

import com.jk.bo.GoodsBo;
import com.jk.model.SeckillOrder;
import com.jk.model.User;
import com.jk.mq.MQSender;
import com.jk.mq.SeckillMessage;
import com.jk.redis.RedisKey;
import com.jk.redis.SeckillKey;
import com.jk.result.CodeMsg;
import com.jk.result.Result;
import com.jk.service.SeckillGoodsServiceFeign;
import com.jk.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/17 19:40
 * @Created by ${jmh}
 */
@Controller
@RequestMapping("seckill")
public class SeckillController {


            @Autowired
            RedisTemplate    redisTemplate;



            @Autowired
            SeckillGoodsServiceFeign seckillGoodsServiceFeign;


            @Autowired
              MQSender    mqSender;



    private HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();

    /**
     系统初始化
     */
    public void afterPropertiesSet() throws Exception {
        List<GoodsBo> goodsList = seckillGoodsServiceFeign.getSeckillGoodsList();
        if (goodsList == null) {
            return;
        }
        for (GoodsBo goods : goodsList) {
           redisTemplate.opsForValue().set(RedisKey.GOODS_STOCK+"_"+goods.getId(),goods.getGoodsStock());
           localOverMap.put(goods.getId(), false);
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

        redisTemplate.opsForValue().set(SeckillKey.SECKILL_PATH+"_"+user1.getUserName()+"_"+goodsId,path);

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
        boolean over = localOverMap.get(goodsId);
        if (over) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }/**/
        //预减库存
        Long stock = redisTemplate.opsForValue().decrement(RedisKey.GOODS_STOCK + "_" + goodsId);
        if (stock < 0) {
            localOverMap.put(goodsId, true);
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }

        //判断是否已经秒杀到了
        SeckillOrder order =  seckillGoodsServiceFeign.getSeckillOrderByUserIdGoodsId((long)user1.getId(), goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_MIAOSHA);
        }

        SeckillMessage mm = new SeckillMessage();
        mm.setUser(user1);
        mm.setGoodsId(goodsId);
        mqSender.sendSeckillMessager(mm);
        return Result.success(0);//排队中
        /*//判断库存
        GoodsBo goods = seckillGoodsService.getseckillGoodsBoByGoodsId(goodsId);
        if(goods == null) {
            return Result.error(CodeMsg.NO_GOODS);
        }
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return Result.error(CodeMsg.MIAO_SHA_OVER);
        }
        //判断是否已经秒杀到了
        SeckillOrder order = seckillOrderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
        if(order != null) {
            return Result.error(CodeMsg.REPEATE_MIAOSHA);
        }
        //减库存 下订单 写入秒杀订单
        OrderInfo orderInfo = seckillOrderService.insert(user, goods);
        return Result.success(orderInfo);*/
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

        long result = seckillGoodsServiceFeign.getSeckillResult((long)user1.getId(), goodsId);

        return Result.success(result);
    }
























}
