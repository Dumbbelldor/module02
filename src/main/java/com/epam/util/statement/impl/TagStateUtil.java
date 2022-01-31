package com.epam.util.statement.impl;

import com.epam.entity.impl.Tag;
import com.epam.util.statement.StatementUtil;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.epam.util.statement.impl.StateUtilConstants.*;

/**
 * A {@link Tag}-specific implementation of the {@link StatementUtil}
 * interface.
 */
@Component
public class TagStateUtil implements StatementUtil<Tag> {

    /**{@inheritDoc}*/
    @Override
    public boolean fillStatement(PreparedStatement statement,
                                 Tag entity)
            throws SQLException {
        boolean flag = false;
        if (statement != null && entity != null) {
            statement.setLong(PARAM_FIRST, entity.getId());
            statement.setString(PARAM_SECOND, entity.getName());

            flag = true;
        }
        return flag;
    }
}
