package com.canno.blog.entity;

import javax.persistence.*;

/**
 * @author Canno
 * @since 2018/6/28 11:17
 */
@Entity
@Table(name = "t_user")
public class User extends BaseEntity{
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "login_name")
    private String loginName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
