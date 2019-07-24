package com.jk.mq;

import com.alibaba.fastjson.JSONObject;
import com.jk.bo.GoodsBo;
import com.jk.mapper.GoodsMapper;
import com.jk.model.SeckillOrder;
import com.jk.model.User;
import com.jk.service.SeckillGoodsService;
import com.jk.service.SeckillOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/18 20:25
 * @Created by ${jmh}
 */

//表示这spring的组件 把此类交给spring容器进行管理
@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    SeckillOrderService  seckillOrderService;

    @Autowired
    GoodsMapper goodsMapper;



    @RabbitListener( queues=MQConfig.MIAOSHAO_QUEUE)
    public  void   receive  (String message){

        log.info("receive message:"+message);

        //1、使用JSONObject
        SeckillMessage mm = (SeckillMessage) JSONObject.parseObject(message, SeckillMessage.class);

        User user = mm.getUser();

        long goodsId = mm.getGoodsId();

        GoodsBo goods =goodsMapper.findSeckillGoodsBoByGoodsId(goodsId);

        int stock = goods.getStockCount();

        if (stock <= 0){
            return;
        }
        //判断是否已经秒杀到了

        SeckillOrder order = seckillOrderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);

         if (order != null){
             return;
         }
        //减库存 下订单 写入秒杀订单

        seckillOrderService.insert(user,goods);

    }






}
