package com.jk.model;

import java.math.BigDecimal;

/**
 * @Classname shoppingcar
 * @Description TODO
 * @Date 2019-07-11 19:27
 * @Created by 谷凌杰
 */
public class shoppingcar {
    private Integer car_id;
    private Integer user_id;
    private String goods_name;
    private Integer goods_num;
    private BigDecimal goods_total_price;
    private BigDecimal goods_unit_price;
    private String goods_img;
    private Integer goods_coin;

    public Integer getGoods_coin() {
        return goods_coin;
    }

    public void setGoods_coin(Integer goods_coin) {
        this.goods_coin = goods_coin;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public BigDecimal getGoods_total_price() {
        return goods_total_price;
    }

    public void setGoods_total_price(BigDecimal goods_total_price) {
        this.goods_total_price = goods_total_price;
    }

    public BigDecimal getGoods_unit_price() {
        return goods_unit_price;
    }

    public void setGoods_unit_price(BigDecimal goods_unit_price) {
        this.goods_unit_price = goods_unit_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }
}
