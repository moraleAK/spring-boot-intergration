package com.canno.blog.dao;

import com.canno.blog.database.dao.GenericDaoImpl;
import com.canno.blog.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @author Canno
 * @since 2018/6/28 14:37
 */
@Repository
public class OrderDao extends GenericDaoImpl<Order, Long> {
    @Override
    protected Class<Order> getDomainClass() {
        return Order.class;
    }
}
