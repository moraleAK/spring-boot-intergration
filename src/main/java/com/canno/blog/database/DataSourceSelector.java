package com.canno.blog.database;

/**
 * User: Rolandz
 * Date: 5/24/16
 * Time: 3:55 PM
 */
public class DataSourceSelector {
    public static final String READ = "READ";
    public static final String WRITE = "WRITE";

    private static final ThreadLocal<String> SELECTED_DATA_SOURCE = new ThreadLocal<String>();

    private DataSourceSelector() {
    }

    public static void setDataSource(String key) {
        SELECTED_DATA_SOURCE.set(key);
    }

    public static void clearDataSource() {
        SELECTED_DATA_SOURCE.set(null);
    }

    public static String getDataSource() {
        return SELECTED_DATA_SOURCE.get();
    }
}
