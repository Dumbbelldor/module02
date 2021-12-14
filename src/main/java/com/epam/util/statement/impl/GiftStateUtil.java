package com.epam.util.statement.impl;

import com.epam.entity.impl.GiftCertificate;
import com.epam.util.statement.StatementUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.epam.util.statement.impl.StateUtilConstants.*;

/**
 * A {@link GiftCertificate}-specific implementation
 * of the {@link StatementUtil} interface.
 */
public enum GiftStateUtil implements StatementUtil<GiftCertificate> {

    INSTANCE;

    /**{@inheritDoc}*/
    @Override
    public boolean fillStatement(PreparedStatement statement,
                                 GiftCertificate entity,
                                 boolean isUpdate) throws SQLException {
        boolean flag = false;
        if (statement != null && entity != null) {
            statement.setString(PARAM_FIRST, entity.getName());
            statement.setString(PARAM_SECOND, entity.getDesc());
            statement.setDouble(PARAM_THIRD, entity.getPrice());
            statement.setInt(PARAM_FORTH, entity.getDuration());
            statement.setTimestamp(PARAM_FIFTH, entity.getCreateDate());
            statement.setTimestamp(PARAM_SIXTH, entity.getLastUpdateTime());

            if (isUpdate) {
                statement.setLong(PARAM_SEVENTH, entity.getId());
            }

            flag = true;
        }
        return flag;
    }
}
