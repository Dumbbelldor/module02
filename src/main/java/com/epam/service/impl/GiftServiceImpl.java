package com.epam.service.impl;

import com.epam.dao.GiftDao;
import com.epam.entity.impl.GiftCertificate;
import com.epam.service.GiftService;
import com.epam.util.sorting.impl.GiftSqlSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.epam.service.impl.SqlQueries.*;

/**
 * Service layer implementation for the {@link GiftService}
 */
@Service
public class GiftServiceImpl implements GiftService {

    private final GiftDao dao;

    @Autowired
    public GiftServiceImpl(GiftDao dao) {
        this.dao = dao;
    }

    /**{@inheritDoc}*/
    @Override
    public boolean save(GiftCertificate entity) {
        return dao.save(GIFT_SAVE, entity);
    }

    /**{@inheritDoc}*/
    @Override
    public Optional<GiftCertificate> findById(Long id) {
        return dao.find(GIFT_FIND_BY_ID, id);
    }

    /**{@inheritDoc}*/
    @Override
    public Optional<GiftCertificate> findByName(String name) {
        return dao.find(GIFT_FIND_BY_NAME, name);
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findAll() {
        return dao.findAll(GIFT_FIND_ALL);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean update(GiftCertificate entity) {
        return dao.update(GIFT_UPDATE, entity);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean deleteById(Long id) {
        return dao.delete(GIFT_DELETE_BY_ID, id);
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByTagId(Long id) {
        return dao.findAll(GIFT_FIND_BY_TAG_ID, id);
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByTagId(Long id, GiftSqlSorting param) {
        return dao.findAll(GIFT_FIND_BY_TAG_ID + param.getOrder(), id);
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByTagName(String name) {
        return dao.findAll(GIFT_FIND_BY_TAG_NAME, name);
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByTagName(String name, GiftSqlSorting param) {
        return dao.findAll(GIFT_FIND_BY_NAME + param.getOrder(), name);
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByPartialName(String part) {
        return dao.findAll(GIFT_FIND_BY_PARTIAL_NAME, surround(part));
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByPartialName(String part, GiftSqlSorting param) {
        return dao.findAll(GIFT_FIND_BY_PARTIAL_NAME + param.getOrder(), surround(part));
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByPartialDesc(String part) {
        return dao.findAll(GIFT_FIND_BY_PARTIAL_DESC, surround(part));
    }

    /**{@inheritDoc}*/
    @Override
    public List<GiftCertificate> findByPartialDesc(String part, GiftSqlSorting param) {
        return dao.findAll(GIFT_FIND_BY_PARTIAL_DESC + param.getOrder(), surround(part));
    }

    /**{@inheritDoc}*/
    @Override
    public boolean addTagToCertificate(Long certId, String name) {
        return dao.addTagByCertId(GIFT_ADD_TAG_TO_CERTIFICATE, certId, name);
    }

    /**
     * Surrounds a {@link String} with {@code "%"}
     * symbols to create a SQL wildcard.
     *
     * @param str string to be surrounded
     *
     * @return a wildcard that will look like {@code "%string%"}
     */
    private String surround(String str) {
        return "%" + str + "%";
    }
}
