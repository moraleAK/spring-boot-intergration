package com.canno.spring.boot.integration.mvc.service;

import com.canno.spring.boot.integration.entity.User;
import com.canno.spring.boot.integration.java18.animation.Canno;
import com.canno.spring.boot.integration.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Canno
 * @since 2018/6/28 14:42
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    @Canno
    public boolean addUser(String userName, String password, String loginName){
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setUserName(userName);
        userDao.persist(user);
        return true;
    }
}
