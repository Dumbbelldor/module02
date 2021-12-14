package com.epam.dao;

import com.epam.entity.impl.GiftCertificate;

/**
 * An extensional interface for the {@link BaseDao} that
 * provides additional methods to work with
 * {@link GiftCertificate} entity.
 */
public interface GiftDao extends BaseDao<GiftCertificate> {

    /**
     *
     */
    boolean addTagByCertId(String sql, Long cerfId, String tagName);
}
