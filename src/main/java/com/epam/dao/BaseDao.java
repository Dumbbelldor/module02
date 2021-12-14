package com.epam.dao;

import com.epam.entity.Entity;

import java.util.List;
import java.util.Optional;

/**
 * Classic DAO layer that establishes
 * connection to a database, creates
 * queried statements and fetches results
 * for a given {@link Entity}.
 *
 * @param <T> an entity
 */
public interface BaseDao<T extends Entity> {

    /**
     * Performs a typical CRUD "create" operation
     * by executing the given SQL query with
     * {@link java.sql.PreparedStatement}.
     * <p>
     * Draws upon entity's data to fill the statement
     * for making a new record in a database.
     * <p>
     * Fetches no results at the end and returns
     * {@code boolean} as an indicator
     * of the accomplished task.
     *
     * @param sql a sql query
     * @param entity an entity to get information from
     *
     * @return true if saving was successful
     */
    boolean save(String sql, T entity);

    /**
     * Performs a typical CRUD "read" operation
     * by executing the given SQL query with
     * {@link java.sql.PreparedStatement}.
     * <p>
     * Can receive any object as the parameter
     * to use it as the searching attribute.
     * <p>
     * Returns an {@link Optional#empty()} if
     * the search was not fruitful or filled with
     * an entity otherwise.
     *
     * @param <P> an object type of the searching parameter
     * @param sql a sql query
     * @param param an object to be used as the searching parameter
     *
     * @return an empty or filled {@link Optional}
     */
    <P> Optional<T> find(String sql, P param);

    /**
     * Performs a typical CRUD "readALl" operation
     * by executing the given SQL query with
     * {@link java.sql.PreparedStatement}.
     * <p>
     * Returns an empty - if nothing
     * was found with the given SQL query - or
     * filled with entities {@link List}.
     *
     * @param sql a sql query
     *
     * @return an empty or filled list
     */
    List<T> findAll(String sql);

    /**
     * Parametrized version of the {@link BaseDao#findAll(String)}
     * that uses the provided searching parameter to
     * retrieve the results as a {@link List}.
     *
     * @param <P> an object type of the searching parameter
     * @param sql a sql query
     * @param param an object to be used as the searching parameter
     *
     * @return an empty or filled {@link List}
     */
    <P> List<T> findAll(String sql, P param);

    /**
     * Performs a typical CRUD "update" operation
     * by executing the given SQL query with
     * {@link java.sql.PreparedStatement}.
     * <p>
     * Draws upon entity's data to fill the statement
     * for updating an existent record in a database.
     * <p>
     * Fetches no results at the end and returns
     * {@code boolean} as an indicator
     * of the accomplished task.
     *
     * @param sql a sql query
     * @param entity an entity to get information from
     *
     * @return true if updating was successful
     */
    boolean update(String sql, T entity);

    /**
     * Performs a typical CRUD "delete" operation
     * by executing the given SQL query with
     * {@link java.sql.PreparedStatement}.
     * <p>
     * Can receive any object as the parameter
     * to use it as the searching attribute.
     * <p>
     * Fetches no results at the end and returns
     * {@code boolean} as an indicator
     * of the accomplished task.
     *
     * @param <P> an object type of the searching parameter
     * @param sql a sql query
     * @param param an object to be used as the searching parameter
     *
     * @return true if updating was successful
     */
    <P> boolean delete(String sql, P param);
}
