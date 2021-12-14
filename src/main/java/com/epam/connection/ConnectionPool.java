package com.epam.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * An interface that provides simple solution
 * for connection pooling.
 */
public interface ConnectionPool {

    /**
     * Retrieves a {@link Connection} from a pool.
     *
     * @return open connection
     *
     * @throws SQLException if a database error occurred
     */
    Connection getConnection() throws SQLException;
}
