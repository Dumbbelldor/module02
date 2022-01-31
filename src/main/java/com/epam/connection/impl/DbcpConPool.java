package com.epam.connection.impl;

import com.epam.connection.ConnectionPool;
import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.Driver;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * An implementation of {@link ConnectionPool} that
 * utilizes Apache DBCP.
 */
@Component
public class DbcpConPool implements ConnectionPool {

    private static final BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:postgresql://localhost:5432/module02");
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
