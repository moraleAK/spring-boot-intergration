package com.canno.spring.boot.integration.mvc.dao;


import com.canno.spring.boot.integration.database.dao.GenericDaoImpl;
import com.canno.spring.boot.integration.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @author CannoGcc
 * @since 2018/6/28 14:37
 */
@Repository
public class OrderDao extends GenericDaoImpl<Order, Long> {

    @Override
    protected Class<Order> getDomainClass() {
        return Order.class;
    }
}
