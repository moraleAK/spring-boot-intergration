package com.canno.spring.boot.integration.mvc.dao;

import com.canno.spring.boot.integration.database.dao.GenericDaoImpl;
import com.canno.spring.boot.integration.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Canno
 * @since 2018/6/28 14:41
 */
@Repository
public class UserDao extends GenericDaoImpl<User, Long> {
    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }
}
