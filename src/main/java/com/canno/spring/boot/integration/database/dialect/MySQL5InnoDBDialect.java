package com.canno.spring.boot.integration.database.dialect;

/**
 * User: Rolandz
 * Date: 5/27/16
 * Time: 4:18 PM
 */
public class MySQL5InnoDBDialect extends org.hibernate.dialect.MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=UTF8";
    }
}
