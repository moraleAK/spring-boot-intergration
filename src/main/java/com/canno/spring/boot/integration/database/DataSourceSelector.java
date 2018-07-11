package com.canno.spring.boot.integration.database;

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

    /**
     * @author Canno
     * @since 2018/7/5 14:55
     */
    //@Configuration
    public static class DataSourceConfiguration {
    //    @Bean
    //    @Primary
    //    @ConfigurationProperties(prefix = "spring.datasource")
    //    public DataSource primaryDataSource() {
    //        return DataSourceBuilder.create().build();
    //    }
    //
    //    @Bean(name = "secondDatasource")
    //    @ConfigurationProperties(prefix = "spring.second-datasource")
    //    public DataSource secondDataSource() {
    //        return DataSourceBuilder.create().build();
    //
    //    }
    //
    //    @Bean
    //    @Primary
    //    public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
    //        return new JdbcTemplate(dataSource);
    //    }
    //
    //    @Bean(name = "secondJdbcTemplate")
    //    public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDatasource") DataSource dataSource) {
    //        return new JdbcTemplate(dataSource);
    //    }

    }
}
