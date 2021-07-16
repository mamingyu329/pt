package com.xxx.web.controller;

import com.xxx.web.domain.User;
import com.xxx.web.service.UserService;
import com.xxx.web.utils.RequestHolder;
import com.xxx.web.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("/toLogin")
    public Result login(@RequestBody User user , HttpSession session) {
        User login = userService.login(user);
        RequestHolder.add(login);
        session.setAttribute("user",login);
        login.setPassword("*****");
        return Result.ok(login);
    }

    @PostMapping("/toReg")
    public Result reg(@RequestBody User user ) {
        User login = userService.reg(user);
        return Result.ok("注册成功",login);
    }

    @GetMapping("/getSession")
    public Result getSession(){
        User user = RequestHolder.getCurrentSysUser();
        return Result.ok(user);
    }




}
