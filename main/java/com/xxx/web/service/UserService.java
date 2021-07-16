package com.xxx.web.service;

import com.xxx.web.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserService extends IService<User> {

    User login(User user);

    User reg(User user);
}
