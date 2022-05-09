package com.ysl.service.UserService;

import com.ysl.dao.UserDao.UserMapper;
import com.ysl.pojo.User;

public class UserMapperServiceImpl implements UserMapperService{
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public boolean userRegister(User user) {
        boolean flag = true;
        int i = userMapper.userRegister(user);
        if (i < 1){
            flag = false;
        }
        return flag;
    }
}
