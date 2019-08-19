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
public @interface SpecificationQuery {
    /**
     * entity 属性名称
     *
     * @return
     */
    String[] property() default {};

    /**
     * 关联表
     *
     * @return
     */
    String join() default "";

    /**
     * 忽略大小写 默认不忽略
     *
     * @return
     */
    boolean ignoreCase() default false;

    /**
     * 比较关系 默认等于
     *
     * @return
     */
    CompareType compare() default CompareType.EQUAL;

    /**
     * 外部字段查询关系
     * <p>
     * 'and' or 'or'
     *
     * @return
     */
    OperatorType operator() default OperatorType.AND;

    /**
     * 内部字段查询关系
     *
     * @return
     */
    OperatorType multiOperator() default OperatorType.OR;

    enum OperatorType {
        /**
         * 对应数据库且查询
         */
        AND,

        /**
         * 或查询
         */
        OR
    }

}

