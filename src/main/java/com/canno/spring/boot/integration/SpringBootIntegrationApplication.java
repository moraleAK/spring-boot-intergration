package com.canno.spring.boot.integration;

import com.canno.spring.boot.integration.netty.CtxInitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootIntegrationApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootIntegrationApplication.class, args);
        CtxInitService ctxInitService = new CtxInitService(9002);
        ctxInitService.start();
    }
}
