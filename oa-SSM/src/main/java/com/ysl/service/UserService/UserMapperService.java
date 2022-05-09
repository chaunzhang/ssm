package com.ysl.service.UserService;

import com.ysl.pojo.User;

public interface UserMapperService {
    //用户登录
    User userLogin(User user);

    //注册用户
    boolean userRegister(User user);

}
