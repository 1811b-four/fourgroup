package com.jk.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.Goods;
import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.model.userBean;
import com.jk.service.shoppingcar.CarServicePublic;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname Controller
 * @Description TODO
 * @Date 2019-07-12 19:20
 * @Created by 谷凌杰
 */
@RestController
@RequestMapping("shopping")
public class CarController1 {
    @Autowired
    private CarServicePublic carServicePublic;


    @GetMapping("query")
    public List<shoppingcar> query(){
        List<shoppingcar> query = carServicePublic.query();
        return query;
    }


    @PostMapping("addNum")
    public boolean addNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.addNum(id);
        return true;
    }

    @PostMapping("subNum")
    public boolean subNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.subNum(id);
        return true;
    }


    @PostMapping("sddLostNum")
    public boolean sddLostNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.sddLostNum(id);
        return true;
    }

    @PostMapping("subLostNum")
    public boolean subLostNum(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.subLostNum(id);
        return true;
    }

    @PostMapping("LostNum")
    public boolean LostNum(@RequestParam(value = "id", required = true) Integer id,@RequestParam(value = "sum", required = true) Integer sum){
        carServicePublic.LostNum(id,sum);
        return true;
    }


    @GetMapping("del")
    public boolean del(@RequestParam(value = "strIds", required = true) Integer[] strIds){
        carServicePublic.del(strIds);
        return true;
    }


    @PostMapping("deleteA")
    public boolean deleteA(@RequestParam(value = "id", required = true) Integer id){
        carServicePublic.deleteA(id);
        return true;
    }


    @PostMapping("sumA")
    public Integer sumA(){
        Integer integer = carServicePublic.sumA();
        return integer;
    }


    @GetMapping("queryDetails")
    public List<t_commodity> queryDetails(){
        List<t_commodity> queryDetails = carServicePublic.queryDetails();
        return queryDetails;
    }

    @PostMapping("addFrom")
    public void addFrom(@RequestParam(value = "id", required = true)Integer id,@RequestParam(value = "sum", required = true)Integer sum){
        carServicePublic.addFrom(id,sum);
    }


    //登录
    @PostMapping("denlu")
    public HashMap<String, Object> denlu(userBean userBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        userBean usersacc= carServicePublic.queryaccount(userBean.getPhone());
        if(usersacc == null){
            hashMap.put("code", 4);
            hashMap.put("msg", "账号不存在");
            return hashMap;
        }
        String password = userBean.getPassword();
        if(!usersacc.getPassword().equals(password)){
            hashMap.put("code", 3);
            hashMap.put("msg", "密码错误");
            return hashMap;
        }
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String name = "jmh";
        String nam = "xu";
        String jmh = jedis.get(name);
        String xu = jedis.get(nam);
        if(xu ==null&&jmh == null){
            jedis.set(name,usersacc.getId()+"");
            jedis.set(nam,usersacc.getUser_name());
        }else{
            jedis.del(name);
            jedis.del(nam);
            jedis.set(name,usersacc.getId()+"");
            jedis.set(nam,usersacc.getUser_name());
        }
        if(usersacc.getPid()==1){
            hashMap.put("code", 2);
            hashMap.put("msg", "登录成功");
            return hashMap;
        }else{
            hashMap.put("code", 1);
            hashMap.put("msg", "登录成功");
            return hashMap;
        }
    }


    @PostMapping("gainMessgerCode")
    public String gainMessgerCode(String phone, HttpServletRequest request){
        //验证手机号是否存在
        userBean account = carServicePublic.findUserByLoginNumber(phone);
        if(account == null){
            return "手机号不存在";
        }
        String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        HashMap<String, Object> params = new HashMap<>();
        String accountSid = "1359dc2a092a49c8bc324327f7c79d49";
        params.put("accountSid", accountSid);//开发者主账号ID（ACCOUNT SID）
        params.put("templateid", "516947505");//短信模板ID
        //6位随机数，验证码
        int code = (int) Math.ceil(Math.random()*899999+100000);
        //String codeStr = String.valueOf(code);
        params.put("param", code);//短信模板中的变量值
        params.put("to", phone);//手机号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        params.put("timestamp", time);//时间戳
        String token = "e51cc4f9e243488586d5c35780b3f08f";
        String sig = Md5Util.getMd532(accountSid+token+time);
        params.put("sig", sig);//签名
        //发送短信
        String returnStr = HttpClientUtil.post(url, params);
        JSONObject jsonObject = JSON.parseObject(returnStr);
        String respCode = jsonObject.getString("respCode");
        if(!respCode.equals("00000")){
            return "发送短信验证码失败";
        }
        //存验证码
        String key = "msgcode"+phone;
        // request.getSession().setAttribute();
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        jedis.set(key,code+"");
        jedis.expire(key,300);
        return "发送短信验证码成功";
    }


    @PostMapping("messageLogin")
    public HashMap<String, Object> messageLogin(String phone, String messageCode, HttpSession session){
        //验证手机号是否存在
        HashMap<String, Object> hashMap = new HashMap<>();
        String name = "jmh";
        String name1 = "xu";
        userBean account = carServicePublic.findUserByLoginNumber(phone);
        if(account==null){
            hashMap.put("code", 5);
            hashMap.put("msg", "账号不存在");
            return hashMap;
        }
        //验证短信验证码是否正确
        //判断key是否存在
        String key = "msgcode"+phone;
        // request.getSession().setAttribute();
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String code = jedis.get(key);
        if(code==null){
            hashMap.put("code", 4);
            hashMap.put("msg", "验证码错误");
            return hashMap;
        }
        if(!messageCode.equals(code)){
            hashMap.put("code", 3);
            hashMap.put("msg", "验证码错误");
            return hashMap;
        }
        //清redis缓存
        jedis.del(key);
        String jmh = jedis.get(name);
        String xu = jedis.get(name1);
        if(!xu.equals("")&&!jmh.equals("")){
            jedis.set(name,account.getId()+"");
            jedis.set(name1,account.getUser_name());
        }else{
            jedis.del(name);
            jedis.del(name1);
            jedis.set(name,account.getId()+"");
            jedis.set(name1,account.getUser_name());
        }
        if(account.getPid()==1){
            hashMap.put("code", 2);
            hashMap.put("msg", "登录成功");
        }else{
            hashMap.put("code", 1);
            hashMap.put("msg", "登录成功");
        }

        return hashMap;
    }



    @PostMapping("gainMessgerCode2")
    public String gainMessgerCode2(String phone){
        //验证手机号是否存在
        userBean account = carServicePublic.findUserByLoginNumber(phone);
        if(account != null){
            return "手机号注册过了，请登录";
        }
        String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        HashMap<String, Object> params = new HashMap<>();
        String accountSid = "1359dc2a092a49c8bc324327f7c79d49";
        params.put("accountSid", accountSid);//开发者主账号ID（ACCOUNT SID）
        params.put("templateid", "516947505");//短信模板ID
        //6位随机数，验证码
        int code = (int) Math.ceil(Math.random()*899999+100000);
        //String codeStr = String.valueOf(code);
        params.put("param", code);//短信模板中的变量值
        params.put("to", phone);//手机号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        params.put("timestamp", time);//时间戳
        String token = "e51cc4f9e243488586d5c35780b3f08f";
        String sig = Md5Util.getMd532(accountSid+token+time);
        params.put("sig", sig);//签名
        //发送短信
        String returnStr = HttpClientUtil.post(url, params);
        JSONObject jsonObject = JSON.parseObject(returnStr);
        String respCode = jsonObject.getString("respCode");
        if(!respCode.equals("00000")){
            return "发送短信验证码失败";
        }
        //存验证码
        String key = "msgcode"+phone;
        // request.getSession().setAttribute();
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        jedis.set(key,code+"");
        jedis.expire(key,300);
        return "发送短信验证码成功";
    }


    @PostMapping("Registration2")
    public HashMap<String, Object> messageLogin2(userBean account, String messageCode){
        HashMap<String, Object> hashMap = new HashMap<>();
        //验证手机号是否存在
        userBean account1 = carServicePublic.findUserByLoginNumber(account.getUser_name());
        if(account1!=null){
            hashMap.put("code", 2);
            hashMap.put("msg", "账号已存在");
            return hashMap;
        }
        //验证短信验证码是否正确
        //判断key是否存在
        String key = "msgcode"+account.getPhone();
        // request.getSession().setAttribute();
        Jedis jedis = new Jedis("192.168.1.122",6379);
        jedis.auth("123456");
        String code = jedis.get(key);
        if(code==null){
            hashMap.put("code", 2);
            hashMap.put("msg", "验证码错误");
            return hashMap;
        }
        if(!messageCode.equals(code)){
            hashMap.put("code", 2);
            hashMap.put("msg", "验证码错误");
            return hashMap;
        }
        //清redis缓存
        carServicePublic.Registration(account);
        hashMap.put("code", 1);
        hashMap.put("msg", "注册成功");
        return hashMap;
    }

}
