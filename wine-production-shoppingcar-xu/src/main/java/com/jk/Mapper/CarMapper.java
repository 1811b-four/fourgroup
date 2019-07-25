package com.jk.Mapper;

import com.jk.model.Goods;
import com.jk.model.shoppingcar;
import com.jk.model.t_commodity;
import com.jk.model.userBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname CarMapper
 * @Description TODO
 * @Date 2019-07-14 11:15
 * @Created by 谷凌杰
 */
public interface CarMapper {

    void addNum(@Param("id") Integer id);

    void subNum(@Param("id")Integer id);

    void subLostNum(@Param("id")Integer id);

    void sddLostNum(@Param("id")Integer id);

    void LostNum(@Param("id")Integer id,@Param("sum")Integer sum);

    void del(@Param("split")Integer[] split);

    void deleteA(@Param("id")Integer id);



    List<t_commodity> queryDetails();

    t_commodity queryListDetails(@Param("id")Integer id);

    void addFrom(shoppingcar s);

    userBean queryaccount(@Param("user_name")String user_name);

    userBean findUserByLoginNumber(@Param("phone")String phone);

    void Registration(userBean account);

    Integer sumA(@Param("integer")Integer integer);

    List<shoppingcar> query(@Param("jmh")Integer integer);
}
