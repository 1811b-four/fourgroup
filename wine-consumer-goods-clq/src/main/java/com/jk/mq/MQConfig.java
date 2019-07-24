package com.jk.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/18 19:36
 * @Created by ${jmh}
 */
@Configuration
public class MQConfig {


      public  static  final   String  MIAOSHAO_QUEUE = "seckill_queue";

      public   static  final  String QUEUE = "queue";

      @Bean
      public MessageConverter getMessageConverter(){
          return new Jackson2JsonMessageConverter();
      };

      @Bean
      public Queue  queue(){
            return  new Queue(MIAOSHAO_QUEUE,true);
      }











}
