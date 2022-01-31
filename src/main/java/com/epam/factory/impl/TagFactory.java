package com.epam.factory.impl;

import com.epam.entity.impl.Tag;
import com.epam.factory.EntityFactory;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.factory.impl.FactoryConstants.*;

/**
 * The {@link Tag}-specific implementation
 * of the {@link EntityFactory}.
 */
@Component
public class TagFactory implements EntityFactory<Tag> {

    /**{@inheritDoc}*/
    @Override
    public Tag create(ResultSet rs) throws SQLException {
        return new Tag(rs.getLong(ID), rs.getString(NAME));
    }
}
