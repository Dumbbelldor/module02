package com.epam.util.statement.impl;

import com.epam.entity.impl.Tag;
import com.epam.util.statement.StatementUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.epam.util.statement.impl.StateUtilConstants.*;

/**
 * A {@link Tag}-specific implementation of the {@link StatementUtil}
 * interface.
 */
public enum TagStateUtil implements StatementUtil<Tag> {

    INSTANCE;

    /**{@inheritDoc}*/
    @Override
    public boolean fillStatement(PreparedStatement statement,
                                 Tag entity,
                                 boolean isUpdate)
            throws SQLException {
        boolean flag = false;
        if (statement != null && entity != null) {
            statement.setString(PARAM_FIRST, entity.getName());

            if (isUpdate) {
                statement.setLong(PARAM_SECOND, entity.getId());
            }

            flag = true;
        }
        return flag;
    }
}
