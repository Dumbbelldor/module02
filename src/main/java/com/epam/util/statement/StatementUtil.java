package com.epam.util.statement;

import com.epam.entity.Entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * An interface that serves as instrument for
 * filling up a {@link PreparedStatement} with
 * entity-specific data.
 *
 * @param <T> any {@link Entity} implementation
 */
public interface StatementUtil<T extends Entity> {

    /**
     * Fills up the given {@link PreparedStatement}
     * with {@link Entity}-specific data to be used for
     * performing saving and updating operations with database.
     * <p>
     * This method has two modes: save mode and update mode. By
     * default, when the parameter {@code isUpdate == false}, the
     * method will not affect any existent record and will perform
     * a typical SQL save operation.
     * <p>
     * If the parameter {@code isUpdate == true}, then the method
     * will be used in "update mode", that will draw a target from
     * the given {@link Entity} to which all the changes will be
     * applied.
     *
     * @param statement a statement to be filled up with data
     * @param entity an entity from which all the data will be drawn
     * @param isUpdate sets the execution mode
     *
     * @return true if the operation was successful
     *
     * @throws SQLException if statement was corrupted
     */
    boolean fillStatement(PreparedStatement statement,
                          T entity,
                          boolean isUpdate) throws SQLException;
}
