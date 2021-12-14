package com.epam.dao.impl;

import com.epam.connection.ConnectionPool;
import com.epam.dao.GiftDao;
import com.epam.entity.impl.GiftCertificate;
import com.epam.factory.EntityFactory;
import com.epam.util.statement.StatementUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * An implementation of {@link GiftDao} interface.
 */
@Repository
public class GiftDaoImpl extends BaseDaoImpl<GiftCertificate> implements GiftDao {

    private static final Logger log = LogManager.getLogger();

    private static final int PARAM_SECOND = 2;

    @Autowired
    public GiftDaoImpl(ConnectionPool pool,
                       StatementUtil<GiftCertificate> util,
                       EntityFactory<GiftCertificate> factory) {
        super(pool, util, factory);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean addTagByCertId(String sql, Long cerfId, String tagName) {
        boolean flag = false;
        if (!sql.isBlank() && cerfId != null && !tagName.isBlank()) {

            try (Connection conn = pool.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setLong(PARAM_FIRST, cerfId);
                statement.setString(PARAM_SECOND, tagName);
                statement.executeUpdate();
                flag = true;
            } catch (SQLException e) {
                log.error(ERROR_SQL, e);
            }

        }
        return flag;
    }
}
