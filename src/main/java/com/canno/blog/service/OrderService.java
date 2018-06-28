package com.canno.blog.service;

import com.canno.blog.dao.OrderDao;
import com.canno.blog.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Canno
 * @since 2018/6/28 14:43
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public boolean orderInit(long amount) {
        Order order = new Order();
        order.setAmount(amount);
        order.setOrderNo(System.currentTimeMillis() + "");
        order.setStatus(0);
        order.setType(0);
        orderDao.persist(order);
        return true;
    }
}
