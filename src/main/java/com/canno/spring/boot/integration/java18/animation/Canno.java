package com.canno.spring.boot.integration.java18.animation;

import java.lang.annotation.*;

/**
 * @author Canno
 * @since 2018/7/10 14:11
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD })
public @interface Canno {
    int count() default 0;
    String value() default "";
}
