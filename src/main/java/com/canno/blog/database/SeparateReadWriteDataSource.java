package com.canno.blog.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * User: Rolandz
 * Date: 5/24/16
 * Time: 4:18 PM
 */
public class SeparateReadWriteDataSource extends AbstractRoutingDataSource {
    private static Logger LOG = LoggerFactory.getLogger(SeparateReadWriteDataSource.class);

    @Override
    public java.util.logging.Logger getParentLogger() {
        return null;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        LOG.debug("Datasource lookup key is {}", DataSourceSelector.getDataSource());
        return DataSourceSelector.getDataSource();
    }
}
