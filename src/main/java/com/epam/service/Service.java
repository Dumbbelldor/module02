package com.epam.service;

import com.epam.entity.Entity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Service layer that provides generic
 * methods to be implemented that covers
 * a database routine work.
 *
 * @param <T> any {@link Entity} implementation
 */
@Component
public interface Service<T extends Entity> {

    /**
     * Saves the given {@link Entity} in a database
     * and returns {@code boolean} result whether
     * it was successful or not.
     *
     * @param entity any {@link Entity} implementation
     *
     * @return true if a new record was created
     */
    boolean save(T entity);

    /**
     * Finds an {@link Entity} in a database
     * and returns it as an {@link Optional}.
     *
     * @param id entity's id stored in a database
     *
     * @return {@link Optional#empty()} or filled with the result
     */
    Optional<T> findById(Long id);

    /**
     * Finds an {@link Entity} in a database
     * and returns it as an {@link Optional}.
     *
     * @param name entity's name stored in a database
     *
     * @return {@link Optional#empty()} or filled with the result
     */
    Optional<T> findByName(String name);

    /**
     * Finds all entities {@link Entity} in a database
     * and returns it as a {@link List}.
     *
     * @return empty {@link List} or filled with the result
     */
    List<T> findAll();

    /**
     * Updates a record in a database with the
     * given {@link Entity} and returns {@code boolean}
     * result whether it was successful or not.
     *
     * @param entity any {@link Entity} implementation
     *
     * @return true if a record was updated
     */
    boolean update(T entity);

    /**
     * Drops a record from a database by the
     * given id.
     *
     * @param id the id of the record
     *
     * @return true if a record was deleted
     */
    boolean deleteById(Long id);
}
