package com.epam.dao.impl;

import com.epam.connection.ConnectionPool;
import com.epam.dao.TagDao;
import com.epam.entity.impl.Tag;
import com.epam.factory.EntityFactory;
import com.epam.util.statement.StatementUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl extends BaseDaoImpl<Tag> implements TagDao {

    @Autowired
    public TagDaoImpl(ConnectionPool pool,
                      StatementUtil<Tag> util,
                      EntityFactory<Tag> factory) {
        super(pool, util, factory);
    }
}
