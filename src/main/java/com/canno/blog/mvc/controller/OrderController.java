package com.canno.blog.mvc.controller;

import com.canno.blog.mvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Canno
 * @since 2018/6/28 14:52
 */
@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping(value = "/order/init")
    public String orderInit(@RequestParam long amount) throws InterruptedException {
        System.out.println();
        return String.valueOf(orderService.orderInit(amount));
    }
}
