package com.thdblog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.thdblog.aspect.WebSecurityConfig;
import com.thdblog.entity.User;
import com.thdblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 15:18
 * @Description
 */
@Controller
@RequestMapping("/admin")
public class UserLoginController {

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

    /**
     * 验证登录
     * @param response
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(HttpServletResponse response, User user, Model model){
        if (userService.login(user.getUsername(),user.getPassword())){
            Cookie cookie = new Cookie(WebSecurityConfig.SESSION_KEY,user.toString());
            response.addCookie(cookie);
            model.addAttribute("user",user);
            System.out.println(cookie.getName());
            return "redirect:/admin/index";
        }else {
            model.addAttribute("error","用户名或密码错误");
            System.out.println("failed");

            return "admin/login";
        }
    }
}
