package com.thdblog.service.impl;

import com.thdblog.dao.UserRepository;
import com.thdblog.entity.User;
import com.thdblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 1:27
 * @Description
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public boolean login(String username,String password){
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (null==user){
            return false;
        }else{
            return true;
        }
    }
}
