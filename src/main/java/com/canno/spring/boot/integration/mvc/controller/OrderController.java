package com.canno.spring.boot.integration.mvc.controller;


import com.canno.spring.boot.integration.java18.animation.Canno;
import com.canno.spring.boot.integration.mvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CannoGcc
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
    @Canno
    public String orderInit(@RequestParam long amount) throws InterruptedException {
        System.out.println();
        return String.valueOf(orderService.orderInit(amount));
    }
}
