package com.epam.config;

import com.epam.connection.ConnectionPool;
import com.epam.connection.impl.DbcpConPool;
import com.epam.dao.BaseDao;
import com.epam.dao.impl.GiftDaoImpl;
import com.epam.dao.impl.TagDaoImpl;
import com.epam.entity.impl.GiftCertificate;
import com.epam.entity.impl.Tag;
import com.epam.factory.impl.GiftFactory;
import com.epam.factory.impl.TagFactory;
import com.epam.service.GiftService;
import com.epam.service.TagService;
import com.epam.service.impl.GiftServiceImpl;
import com.epam.service.impl.TagServiceImpl;
import com.epam.util.statement.StatementUtil;
import com.epam.util.statement.impl.GiftStateUtil;
import com.epam.util.statement.impl.TagStateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

@Configuration
@ComponentScan("com.epam.*")
public class AppConfig {

    private final ServletContext context;

    @Autowired
    public AppConfig(ServletContext context) {
        this.context = context;
    }

    @Bean
    public GiftService giftCertificateService() {
        return new GiftServiceImpl(new GiftDaoImpl(DbcpConPool.INSTANCE,
                GiftStateUtil.INSTANCE, GiftFactory.INSTANCE));
    }

    @Bean
    public TagService tagService() {
        return new TagServiceImpl(new TagDaoImpl(DbcpConPool.INSTANCE,
                TagStateUtil.INSTANCE, TagFactory.INSTANCE));
    }

    @Bean
    public ConnectionPool connectionPool() {
        return DbcpConPool.INSTANCE;
    }

    @Bean
    public StatementUtil<GiftCertificate> giftCertificateStatementUtil() {
        return GiftStateUtil.INSTANCE;
    }

    @Bean
    public StatementUtil<Tag> tagStatementUtil() {
        return TagStateUtil.INSTANCE;
    }

    @Bean
    public BaseDao<GiftCertificate> giftCertificateBaseDao() {
        return new GiftDaoImpl(DbcpConPool.INSTANCE,
                GiftStateUtil.INSTANCE, GiftFactory.INSTANCE);
    }

    @Bean
    public BaseDao<Tag> tagBaseDao() {
        return new TagDaoImpl(DbcpConPool.INSTANCE,
                TagStateUtil.INSTANCE, TagFactory.INSTANCE);
    }

    @Bean
    public ServletContext servletContext() {
        return context;
    }
}
