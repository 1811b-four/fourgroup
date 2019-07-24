package com.jk.service;

import com.jk.bo.GoodsBo;
import com.jk.mapper.GoodsMapper;
import com.jk.mapper.SeckillOrderMapper;
import com.jk.model.OrderInfo;
import com.jk.model.SeckillOrder;
import com.jk.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/18 11:12
 * @Created by ${jmh}
 */
@Slf4j
@Service("seckillOrderService")
public class SeckillOrderServiceImpl implements SeckillOrderService{

        @Autowired
       private SeckillOrderMapper  seckillOrderMapper;

        @Autowired
        private GoodsMapper goodsMapper;

        @Autowired
        private  OrderService orderService;





    @Override
    public SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId) {
        return seckillOrderMapper.getSeckillOrderByUserIdGoodsId(userId,goodsId);
    }

    @Transactional
    @Override
    public OrderInfo insert(User user, GoodsBo goods) {

        //秒杀商品库存减一
        int success = goodsMapper.updateStock(goods.getId());

        if(success == 1) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setCreateDate(new Date());
            orderInfo.setAddrId(0L);
            orderInfo.setGoodsCount(1);
            orderInfo.setGoodsId(goods.getId());
            orderInfo.setGoodsName(goods.getGoodsName());
            orderInfo.setGoodsPrice(goods.getSeckillPrice());
            orderInfo.setOrderChannel(1);
            orderInfo.setStatus(0);
            orderInfo.setUserId((long)user.getId());
            //添加信息进订单
            long orderId = orderService.addOrder(orderInfo);
            log.info("orderId -->" +orderId+"");
            SeckillOrder seckillOrder = new SeckillOrder();
            seckillOrder.setGoodsId(goods.getId());
            seckillOrder.setOrderId(orderInfo.getId());
            seckillOrder.setUserId((long)user.getId());
            //插入秒杀表
            seckillOrderMapper.insertSelective(seckillOrder);
            return orderInfo;
        }else {
         /*   setGoodsOver(goods.getId());*/
              return null;
        }
    }

    @Override
    public long getSeckillResult(long userId, long goodsId) {
        SeckillOrder order = getSeckillOrderByUserIdGoodsId(userId, goodsId);
        if(order != null) {//秒杀成功
            return order.getOrderId();
        }else {

                return -1;


        }
    }


}
