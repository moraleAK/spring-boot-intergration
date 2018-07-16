package com.canno.spring.boot.integration.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Canno
 * @since 2018/7/13 15:00
 */
@WebFilter
@Configuration
public class SecurityRequestFilter extends GenericFilterBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        if(session == null){
            logger.info("non session");

        }
        logger.info(session.getId());
        String uri = httpRequest.getRequestURI();
        if(uri.contains(".jsp")){
            request.setAttribute("name",uri);
            request.getRequestDispatcher("/jsp?name="+uri).forward(request,response);
        }else {
            chain.doFilter(request, response);
        }
    }
}
