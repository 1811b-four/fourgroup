package com.jk.mq;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/18 19:48
 * @Created by ${jmh}
 */
@Service
public class MQSender {


       private   static Logger log = LoggerFactory.getLogger(MQSender.class);

         @Autowired
         AmqpTemplate  amqpTemplate;





      public  void  sendSeckillMessager(SeckillMessage mm){


          String msg = JSON.toJSONString(mm);

          log.info("send message:"+msg);

               amqpTemplate.convertAndSend(MQConfig.MIAOSHAO_QUEUE,msg);
       }


}
