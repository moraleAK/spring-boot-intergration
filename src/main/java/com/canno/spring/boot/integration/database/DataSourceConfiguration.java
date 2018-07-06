package com.canno.spring.boot.integration.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Canno
 * @since 2018/7/5 14:55
 */
//@Configuration
public class DataSourceConfiguration {
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
