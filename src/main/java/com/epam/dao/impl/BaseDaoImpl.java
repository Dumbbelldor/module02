package com.epam.dao.impl;

import com.epam.connection.ConnectionPool;
import com.epam.dao.BaseDao;
import com.epam.entity.Entity;
import com.epam.factory.EntityFactory;
import com.epam.util.statement.StatementUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * An implementation of {@link BaseDao} interface.
 */
public class BaseDaoImpl<T extends Entity> implements BaseDao<T> {

    private static final Logger log = LogManager.getLogger();

    protected static final String ERROR_SQL = "Error in SQL query";

    protected static final int PARAM_FIRST = 1;

    protected final ConnectionPool pool;
    private final StatementUtil<T> util;
    private final EntityFactory<T> factory;

    public BaseDaoImpl(ConnectionPool pool,
                       StatementUtil<T> util,
                       EntityFactory<T> factory) {
        this.pool = pool;
        this.util = util;
        this.factory = factory;
    }

    /**{@inheritDoc}*/
    @Override
    public boolean save(String sql, T entity) {
        boolean flag = false;
        if (!sql.isBlank() && entity != null) {

            try (Connection conn = pool.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                util.fillStatement(statement, entity);
                statement.executeUpdate();
                flag = true;
            } catch (SQLException e) {
                log.error(ERROR_SQL, e);
            }

        }
        return flag;
    }

    /**{@inheritDoc}*/
    @Override
    public <P> Optional<T> find(String sql, P param) {
        Optional<T> result = Optional.empty();
        if (!sql.isBlank() && param != null) {

            try (Connection conn = pool.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setObject(PARAM_FIRST, param);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    result = Optional.of(factory.create(rs));
                }
            } catch (SQLException e) {
                log.error(ERROR_SQL, e);
            }

        }
        return result;
    }

    /**{@inheritDoc}*/
    @Override
    public List<T> findAll(String sql) {
        List<T> result = new ArrayList<>();
        if (!sql.isBlank()) {

            try (Connection conn = pool.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    result.add(factory.create(rs));
                }
            } catch (SQLException e) {
                log.error(ERROR_SQL, e);
            }

        }
        return result;
    }

    /**{@inheritDoc}*/
    @Override
    public <P> List<T> findAll(String sql, P param) {
        List<T> result = new ArrayList<>();
        if (!sql.isBlank() && param != null) {

            try (Connection conn = pool.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setObject(PARAM_FIRST, param);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    result.add(factory.create(rs));
                }
            } catch (SQLException e) {
                log.error(ERROR_SQL, e);
            }

        }
        return result;
    }

    /**{@inheritDoc}*/
    @Override
    public <P> boolean delete(String sql, P param) {
        boolean flag = false;
        if (!sql.isBlank() && param != null) {

            try (Connection conn = pool.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setObject(PARAM_FIRST, param);
                statement.executeUpdate();
                flag = true;
            } catch (SQLException e) {
                log.error(ERROR_SQL, e);
            }

        }
        return flag;
    }
}
