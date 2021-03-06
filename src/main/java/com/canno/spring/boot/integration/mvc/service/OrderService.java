package com.canno.spring.boot.integration.mvc.service;

import com.canno.spring.boot.integration.entity.Order;
import com.canno.spring.boot.integration.java18.animation.Canno;
import com.canno.spring.boot.integration.mvc.HttpClientUtils;
import com.canno.spring.boot.integration.mvc.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Canno
 * @since 2018/6/28 14:43
 */
@Service
@Transactional
public class OrderService implements OrderServiceInt {
    @Autowired
    OrderDao orderDao;

    @Override
    public boolean orderInit(long amount) {
        Order order = new Order();
        order.setAmount(amount);
        order.setOrderNo(System.currentTimeMillis() + "");
        order.setStatus(0);
        order.setType(0);
        orderDao.persist(order);
        return true;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("amount",10000);
        HttpClientUtils.sendHttpRequest("http://localhost:60003/order/init",map);
    }
}
