package com.ysl.dao.UserDao;

import com.ysl.pojo.User;

public interface UserMapper {

    //用户登录
    User userLogin(User user);

    //注册用户
    int userRegister(User user);
}
