package com.canno.spring.boot.integration.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Canno
 * @since 2018/7/12 19:00
 */
@Controller
public class JspController {

    @RequestMapping(value = "/kazila")
    public ModelAndView jsp(){
        return new ModelAndView("index");
    }

}
