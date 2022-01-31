package com.epam.factory.impl;

import com.epam.entity.impl.GiftCertificate;
import com.epam.factory.EntityFactory;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.factory.impl.FactoryConstants.*;

/**
 * The {@link GiftCertificate}-specific implementation
 * of the {@link EntityFactory}.
 */
@Component
public class GiftFactory implements EntityFactory<GiftCertificate> {

    /**{@inheritDoc}*/
    @Override
    public GiftCertificate create(ResultSet rs) throws SQLException {
        return GiftCertificate.newBuilder()
                .setId(rs.getLong(ID))
                .setName(rs.getString(NAME))
                .setDesc(rs.getString(GC_DESC))
                .setPrice(rs.getDouble(GC_PRICE))
                .setDuration(rs.getInt(GC_DURATION))
                .setCreateDate(rs.getTimestamp(GC_CREATE_DATE))
                .setLastUpdateTime(rs.getTimestamp(GC_LAST_UPDATE))
                .build();
    }
}
