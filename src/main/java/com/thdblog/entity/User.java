package com.thdblog.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author tanhudong
 * @mail 514390025@qq.com
 * @date 2018/10/1 0:42
 * @Description
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    @Column(name = "id",columnDefinition = "varchar(64) binary")
    private String id;

    @Column(name = "username",nullable = false,length = 32)
    private String username;

    @Column(name = "password",nullable = false,length = 32)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
