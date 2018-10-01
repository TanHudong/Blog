package com.thdblog.service;

import javax.transaction.Transactional;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 1:24
 * @Description
 */
@Transactional(rollbackOn = Exception.class)
public interface UserService {
    /**
     * 登录操作
     * @param username 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    boolean login(String username,String password);
}
