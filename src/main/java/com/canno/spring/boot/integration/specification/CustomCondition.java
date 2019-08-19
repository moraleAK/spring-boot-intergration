package com.canno.spring.boot.integration.specification;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Gin
 * @since 2019/6/10 17:23
 */
public class CustomCondition {
    CustomCondition(String columnName, String name, Object value, CompareType operatorType) {
        this.columnName = columnName;
        this.name = name;
        this.value = value;
        this.operatorType = operatorType;
    }

    /**
     * 实体对应的列名
     */
    String columnName;

    /**
     * 查询条件的名称
     */
    String name;

    /**
     * 内部查询条件
     */
    Set<String> inNames = new HashSet<>();

    /**
     * 条件对应值，须和实体列类型一一对应
     */
    Object value;

    /**
     * 操作符，大于、小于 .et
     */
    CompareType operatorType;

    boolean ignoreCase;

    String joinName;

    /**
     * 外部查询关联
     */
    SpecificationQuery.OperatorType linkedType = SpecificationQuery.OperatorType.AND;

    /**
     * 内部查询关联
     */
    SpecificationQuery.OperatorType inLinkedType = SpecificationQuery.OperatorType.AND;

    void setLinkedType(SpecificationQuery.OperatorType linkedType) {
        this.linkedType = linkedType;
    }

    void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    void setJoinName(String joinName) {
        this.joinName = joinName;
    }
}
