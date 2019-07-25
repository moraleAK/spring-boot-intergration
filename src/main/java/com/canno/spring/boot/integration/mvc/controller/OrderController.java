package com.canno.spring.boot.integration.mvc.controller;


import com.canno.spring.boot.integration.java18.animation.Canno;
import com.canno.spring.boot.integration.mvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @Canno
    public String orderInit(@RequestParam long amount) throws InterruptedException {
        System.out.println();
        return String.valueOf(orderService.orderInit(amount));
    }

    @ResponseBody
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    @Canno
    public String orderInit(@RequestBody Map<String, String> map) throws InterruptedException {
        System.out.println();
        return String.valueOf(orderService.orderInit(Long.valueOf(map.get("amount"))));
    }

    @RequestMapping(value = "/login")
    public String getIndex(){
        return "index";
    }
}
