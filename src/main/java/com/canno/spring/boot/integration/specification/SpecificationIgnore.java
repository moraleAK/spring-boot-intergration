package com.canno.spring.boot.integration.specification;

import java.lang.annotation.*;

/**
 * 忽略查询条件
 *
 * @author Gin
 * @since 2019/4/13 13:43
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SpecificationIgnore {
}
