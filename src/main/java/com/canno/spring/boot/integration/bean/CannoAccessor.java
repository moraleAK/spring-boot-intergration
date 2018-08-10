package com.canno.spring.boot.integration.bean;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Canno
 * @since 2018/7/12 15:23
 */
public class CannoAccessor implements InitializingBean , BeanClassLoaderAware {
    @Override
    public void afterPropertiesSet() {
        throw new RuntimeException("a Hahahaha hahaha!");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }
}
