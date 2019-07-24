package com.jk.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.model.Order;
import com.jk.model.shoppingcar;
import com.jk.service.OrderServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("order")
public class OrdersController {

    @Autowired
    private OrderServiceApi orderServiceApi;

    @GetMapping("add")
    public void add(){
        orderServiceApi.add();
    }

    @GetMapping("queryList")
    public List<shoppingcar> queryList(@RequestParam(value = "strIds") String strIds){
        //用逗号将字符串分开，得到字符串数组
        String[] strs=strIds.split(",");
        //将字符串数组转换成集合list
        List list= Arrays.asList(strs);
        List<shoppingcar> shoppingcars = new ArrayList<shoppingcar>();
        int goodNum = 0;
        int totalPrice = 0;

        for (int i = 0 ; i < list.size() ; i++ ){
            shoppingcar shoppingcar1 = orderServiceApi.queryList((String)list.get(i));
            shoppingcars.add(shoppingcar1);
        };
        System.out.println(shoppingcars);
        return shoppingcars;
    }

    @PostMapping("addOrders")
    public Boolean addOrders(Order order){
        /*SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        order.setOrderNum(newDate+result);
        order.setUserPhone(123456);*/
        orderServiceApi.addOrders(order);
        return true;
    }

    //支付
    @GetMapping("aliAddmoney")
    public String aliAddmoney(HttpServletRequest request, HttpServletRequest response, String price) throws Exception {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl("http://localhost:8099/toInvInfoPage?id=");
        alipayRequest.setNotifyUrl("localhost:8099/toInvInfoPage?id=");

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =price;
        //订单名称，必填
        String subject = "酒仙网";
        //商品描述，可空
        String body = "酒仙网";
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result =alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("返回页面"+ result);
        return result;
    }

}
