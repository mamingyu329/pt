package com.xxx.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.web.domain.User;
import com.xxx.web.service.UserService;
import com.xxx.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    UserMapper userMapper;




    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",user.getAccount());
        queryWrapper.eq("password",user.getPassword());
        User one = super.getOne(queryWrapper);
        return one;
    }

    @Override
    public User reg(User user) {
        super.save(user);
        return user;
    }
}




