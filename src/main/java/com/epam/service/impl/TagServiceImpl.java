package com.epam.service.impl;

import com.epam.dao.TagDao;
import com.epam.entity.impl.Tag;
import com.epam.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.epam.service.impl.SqlQueries.*;

/**
 * Service layer implementation for the {@link TagService}
 */
@Service
public class TagServiceImpl implements TagService {

    private final TagDao dao;

    @Autowired
    public TagServiceImpl(TagDao dao) {
        this.dao = dao;
    }

    /**{@inheritDoc}*/
    @Override
    public boolean save(Tag entity) {
        return dao.save(TAG_SAVE, entity);
    }

    /**{@inheritDoc}*/
    @Override
    public Optional<Tag> findById(Long id) {
        return dao.find(TAG_FIND_BY_ID, id);
    }

    /**{@inheritDoc}*/
    @Override
    public Optional<Tag> findByName(String name) {
        return dao.find(TAG_FIND_BY_NAME, name);
    }

    /**{@inheritDoc}*/
    @Override
    public List<Tag> findAll() {
        return dao.findAll(TAG_FIND_ALL);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean update(Tag entity) {
        return dao.update(TAG_UPDATE, entity);
    }

    /**{@inheritDoc}*/
    @Override
    public boolean deleteById(Long id) {
        return dao.delete(TAG_DELETE_BY_ID, id);
    }

    /**{@inheritDoc}*/
    @Override
    public List<Tag> findByGiftId(Long id) {
        return dao.findAll(TAG_FIND_BY_GIFT_ID, id);
    }

    /**{@inheritDoc}*/
    @Override
    public List<Tag> findByGiftName(String name) {
        return dao.findAll(TAG_FIND_BY_GIFT_NAME, name);
    }
}
