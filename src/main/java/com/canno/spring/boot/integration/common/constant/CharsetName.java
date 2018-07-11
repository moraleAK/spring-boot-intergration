package com.canno.spring.boot.integration.common.constant;

/**
 * @author Canno
 * @since 2018/7/11 16:35
 */
public enum CharsetName {
    /**
     * u
     */
    UTF8("UTF-8"),

    GBK("GBK");

    private final String value;

    CharsetName(String value){
        this.value = value;
    }

    public String value(){
        return this.value;
    }

}
