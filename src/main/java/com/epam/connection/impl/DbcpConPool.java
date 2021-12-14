package com.epam.connection.impl;

import com.epam.connection.ConnectionPool;
import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * An implementation of {@link ConnectionPool} that
 * utilizes Apache DBCP.
 */
public enum DbcpConPool implements ConnectionPool {

    INSTANCE;

    private static final BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setDriver(new Driver());
        ds.setUsername("postgres");
        ds.setPassword("root");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
    }

    /**{@inheritDoc}*/
    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
