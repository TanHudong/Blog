package com.thdblog.dao;

import com.thdblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 1:03
 * @Description  用户数据持久化接口
 */
@Transactional(rollbackOn = Exception.class)
public interface UserRepository extends JpaRepository<User,String> {

//    @Query("from User u where u.username= :username and u.password= :password")
//    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    User findByUsernameAndPassword(String username,String password);
}
