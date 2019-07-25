package com.canno.spring.boot.integration.specification;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Gin
 * @since 2019/6/10 17:23
 */
public class CustomCondition {
    public CustomCondition(String columnName, String name, Object value, CompareType operatorType) {
        this.columnName = columnName;
        this.name = name;
        this.value = value;
        this.operatorType = operatorType;
    }

    /**
     * 实体对应的列名
     */
    protected String columnName;

    /**
     * 查询条件的名称
     */
    protected String name;

    /**
     * 内部查询条件
     */
    protected Set<String> inNames = new HashSet<>();

    /**
     * 条件对应值，须和实体列类型一一对应
     */
    protected Object value;

    /**
     * 操作符，大于、小于 .et
     */
    protected CompareType operatorType;

    protected boolean ignoreCase;

    /**
     * 外部查询关联
     */
    protected QueryCustom.LinkedType linkedType = QueryCustom.LinkedType.AND;

    /**
     * 内部查询关联
     */
    protected QueryCustom.LinkedType inLinkedType = QueryCustom.LinkedType.AND;

    public void setLinkedType(QueryCustom.LinkedType linkedType) {
        this.linkedType = linkedType;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }
}
