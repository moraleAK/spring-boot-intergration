package com.canno.blog.controller;

import com.canno.blog.service.OrderService;
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
    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/order/init")
    public String orderInit(@RequestParam long amount) throws InterruptedException {
        Thread.sleep(10000L);
        System.out.println();
        return String.valueOf(orderService.orderInit(amount));
    }
}
