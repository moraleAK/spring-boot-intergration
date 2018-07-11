package com.canno.spring.boot.integration.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Canno
 * @since 2018/7/11 10:00
 */
//@Component
//@ServletComponentScan
@Configuration
@WebFilter(urlPatterns = "/*", filterName = "requestTimerFilter")
public class RequestTimerFilter extends OncePerRequestFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        Object ret = null;
        long begin = System.currentTimeMillis();

        try {
            filterChain.doFilter(request, response);
        } catch (Throwable var9) {
            logger.error("RequestTimingFilter: {}", var9.getMessage());
        } finally {
            logger.info("Duration: {}ms for \"{}\"",
                    (System.currentTimeMillis() - begin),
                    request.getRequestURI()
            );
        }
    }
}
