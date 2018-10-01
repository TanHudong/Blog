package com.thdblog.controller;

import com.thdblog.service.UserService;
import com.thdblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 1:38
 * @Description
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录模块
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "admin/login";
    }
}
