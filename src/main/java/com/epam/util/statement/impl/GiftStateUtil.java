package com.epam.util.statement.impl;

import com.epam.entity.impl.GiftCertificate;
import com.epam.util.statement.StatementUtil;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.epam.util.statement.impl.StateUtilConstants.*;

/**
 * A {@link GiftCertificate}-specific implementation
 * of the {@link StatementUtil} interface.
 */
@Component
public class GiftStateUtil implements StatementUtil<GiftCertificate> {

    /**{@inheritDoc}*/
    @Override
    public boolean fillStatement(PreparedStatement statement,
                                 GiftCertificate entity) throws SQLException {
        boolean flag = false;
        if (statement != null && entity != null) {
            statement.setLong(PARAM_FIRST, entity.getId());
            statement.setString(PARAM_SECOND, entity.getName());
            statement.setString(PARAM_THIRD, entity.getDesc());
            statement.setDouble(PARAM_FORTH, entity.getPrice());
            statement.setInt(PARAM_FIFTH, entity.getDuration());
            statement.setTimestamp(PARAM_SIXTH, entity.getCreateDate());
            statement.setTimestamp(PARAM_SEVENTH, entity.getLastUpdateTime());

            flag = true;
        }
        return flag;
    }
}
