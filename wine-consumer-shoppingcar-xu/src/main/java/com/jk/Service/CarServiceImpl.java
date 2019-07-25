package com.jk.Service;

import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.model.userBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname CarServiceImpl
 * @Description TODO
 * @Date 2019-07-14 11:04
 * @Created by 谷凌杰
 */
@RequestMapping("/error")
@Component
public class CarServiceImpl implements CarService {
    @Override
    public List<shoppingcar> query() {
        return null;
    }

    @Override
    public void addNum(Integer id) {

    }

    @Override
    public void subNum(Integer id) {

    }

    @Override
    public void subLostNum(Integer id) {

    }

    @Override
    public void sddLostNum(Integer id) {

    }

    @Override
    public void LostNum(Integer id, Integer sum) {

    }

    @Override
    public void del(Integer[] strIds) {

    }

    @Override
    public void deleteA(Integer id) {

    }

    @Override
    public Integer sumA() {
        return null;
    }

    @Override
    public List<t_commodity> queryDetails() {
        return null;
    }

    @Override
    public t_commodity queryListDetails(Integer id) {
        return null;
    }

    @Override
    public void addFrom(Integer id, Integer sum) {

    }

    @Override
    public userBean queryaccount(String user_name) {
        return null;
    }

    @Override
    public userBean findUserByLoginNumber(String phone) {
        return null;
    }

    @Override
    public void Registration(userBean account) {

    }


}
