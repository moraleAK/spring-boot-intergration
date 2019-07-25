package com.canno.spring.boot.integration.specification;

/**
 * @author Gin
 * @since 2019/3/8 15:20
 */
public enum CompareType {
    /**
     * 大于
     */
    GRATER_THAN(" > ", "大于"),
    /**
     * 大于等于
     */
    GRATER_THAN_AND_EQUAL(" >= ", "大于等于"),

    /**
     * 小于
     */
    LESS_THAN(" < ", "小于"),

    /**
     * 小于等于
     */
    LESS_THAN_AND_EQUAL(" <=", "小于等于"),

    /**
     * 等于
     */
    EQUAL(" = ", "等于"),

    /**
     * 包含
     */
    CONTAIN(" LIKE '%%' ", "包含"),

    /**
     * 起始位置包含
     */
    CONTAIN_START_WITH(" LIKE ", "起始位置包含"),

    /**
     * 不包含
     */
    NOT_CONTAIN(" NOT CONTAIN ", "不包含"),

    /**
     * 结束位置包含
     */
    CONTAIN_END_WITH(" LIKE ", "结束位置包含"),

    /**
     * 都不是
     */
    ALL_NOT(" NOT IN() ", "都不是"),

    /**
     * 任意
     */
    ANY(" IN()", "任一"),

    /**
     * null or ''
     */
    NULL(" IS NULL", "为空"),

    ;
    String operator;
    String desc;

    CompareType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public String getDesc() {
        return desc;
    }

    CompareType(String operator, String desc) {
        this.operator = operator;
        this.desc = desc;
    }

    public static CompareType getByName(String name) {
        for (CompareType type : CompareType.values()) {
            if (type.name().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
