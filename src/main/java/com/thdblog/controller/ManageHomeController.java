package com.thdblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/4 15:13
 * @Description
 */
@Controller
@RequestMapping(value = "/admin")
public class ManageHomeController {
    /**
     * 首页刷新
     * @return
     */
    @RequestMapping(value = {"","/","/index"},method = {RequestMethod.POST,RequestMethod.GET})
    public String dashboard(){
        return "admin/index";
    }

//    /**
//     * 跳转到博客管理界面
//     * @return
//     */
//    @RequestMapping(value = "/blog",method = {RequestMethod.POST,RequestMethod.GET})
//    public String toBlogManagement(){
//        return "admin/blog";
//    }
//
//    /**
//     * 跳转到类型管理界面
//     * @return
//     */
//    @RequestMapping(value = "/category",method = {RequestMethod.POST,RequestMethod.GET})
//    public String toCategoryManagement(){
//        return "admin/category";
//    }
}
