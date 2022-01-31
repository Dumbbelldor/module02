package com.epam.factory;

import com.epam.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An abstract factory for creating
 * an {@link Entity} out of the provided
 * {@link ResultSet}.
 *
 * @param <T> an entity to be created
 */
public interface EntityFactory<T extends Entity> {

    /**
     * Constructs an {@link Entity} from the given
     * {@link ResultSet}.
     *
     * @param rs a result set
     *
     * @return an entity
     *
     * @throws SQLException if result set was corrupted
     */
    T create(ResultSet rs) throws SQLException;
}
