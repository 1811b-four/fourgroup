package com.jk.mapper;

import com.jk.model.UserBean;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserBean findPhoeNumberByUserType(String phoneNumber);
}
