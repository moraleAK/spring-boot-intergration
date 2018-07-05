package com.canno.blog.mvc.service;

import com.canno.blog.mvc.dao.UserDao;
import com.canno.blog.entity.User;
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

    public boolean addUser(String userName, String password, String loginName){
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        user.setUserName(userName);
        userDao.persist(user);
        return true;
    }
}
