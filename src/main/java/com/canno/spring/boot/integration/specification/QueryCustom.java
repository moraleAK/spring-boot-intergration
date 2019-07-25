package com.canno.spring.boot.integration.specification;

import java.lang.annotation.*;

/**
 * 自定义查询
 *
 * @author Gin
 * @since 2019/4/12 11:02
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface QueryCustom {
    /**
     * 对于实体字段名称
     *
     * @return
     */
    String[] column() default {};

    /**
     * 忽略大小写
     *
     * @return
     */
    boolean ignoreCase() default false;

    /**
     * 操作符类型
     *
     * @return
     */
    CompareType operator() default CompareType.EQUAL;

    /**
     * 转换方式默认不转换
     *
     * @return
     */
    CastType castType() default CastType.DEFAULT;

    /**
     *  外部字段查询关系
     *
     * 'and' or 'or'
     * @return
     */
    LinkedType linkedType() default LinkedType.AND;

    /**
     * 内部字段查询关系
     *
     * @return
     */
    LinkedType multiLinkedType() default LinkedType.AND;

    enum CastType {
        /**
         * 不转换
         */
        DEFAULT,

        DATE,

        END_DATE,
    }

    enum LinkedType{
        AND,

        OR
    }

}

