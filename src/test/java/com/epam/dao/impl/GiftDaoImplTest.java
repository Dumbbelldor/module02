package com.epam.dao.impl;

import com.epam.connection.ConnectionPool;
import com.epam.dao.BaseDao;
import com.epam.entity.impl.GiftCertificate;
import com.epam.factory.impl.GiftFactory;
import com.epam.util.statement.impl.GiftStateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GiftDaoImplTest {

    private static final String SAVE = """
                insert into gift_certificate
                (id, name, description, price, duration, create_date, last_update_time)
                values (12, ?, ?, ?, ?, ?, ?)""";

    private static final String FIND = """
                select * from gift_certificate
                where id = ?""";

    private static final String FIND_ALL = """
                select *
                from gift_certificate""";

    private static final String FIND_ALL_PARAMETRIZED = """
                select *
                from gift_certificate
                where name = ?""";

    private static final String UPDATE = """
                update gift_certificate
                set name = ?, description = ?, price = ?, duration = ?,
                create_date = ?, last_update_time = ?
                where id = ?""";

    private static final String DELETE = """
                delete from gift_certificate
                where id = ?""";

    @Mock
    private final ConnectionPool pool = mock(ConnectionPool.class);

    @InjectMocks
    private final BaseDao<GiftCertificate> dao = new GiftDaoImpl(pool,
            new GiftStateUtil(), new GiftFactory());

    private GiftCertificate testEntity;
    private List<GiftCertificate> testList;

    @BeforeEach
    void setUp() throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:h2:mem:", "sa", "");
        String[] queries = prepareSql();
        for (var elem: queries) {
            try (PreparedStatement statement = connection.prepareStatement(elem)) {
                statement.executeUpdate();
            }
        }

        testEntity = GiftCertificate.newBuilder()
                .setId(12L)
                .setName("test")
                .setDesc("desc")
                .setDuration(4)
                .setPrice(123)
                .setCreateDate(null)
                .setLastUpdateTime(null)
                .build();
        testList = List.of(testEntity);

        when(pool.getConnection()).thenReturn(connection);
    }

    @Test
    void save() {
        assertTrue(dao.save(SAVE, testEntity));
    }

    @Test
    void find() {
        var actual = dao.find(FIND, 12L)
                .orElseThrow();
        assertEquals(testEntity, actual);
    }

    @Test
    void findAll() {
        var actual = dao.findAll(FIND_ALL);
        assertEquals(testList, actual);
    }

    @Test
    void testFindAll() {
        var actual = dao.findAll(FIND_ALL_PARAMETRIZED, "test");
        assertEquals(testList, actual);
    }

    @Test
    void update() {
        GiftCertificate updateEntity = GiftCertificate.newBuilder()
                .setId(12L)
                .setName("test23")
                .setDesc("desc123")
                .setDuration(4)
                .setPrice(100)
                .setCreateDate(null)
                .setLastUpdateTime(null)
                .build();
        assertTrue(dao.save(UPDATE, updateEntity));
    }

    @Test
    void delete() {
        assertTrue(dao.delete(DELETE, 12L));
    }

    private String[] prepareSql() {
        return new String[]
                {
                        """
                        create table if not exists gift_certificate
                        (
                        	id bigserial not null
                        		constraint gift_certificate_pk
                        			primary key,
                        	name varchar(100),
                        	description varchar(500),
                        	price numeric,
                        	duration integer,
                        	create_date timestamp default now(),
                        	last_update_time timestamp default now()
                        );""",
                        """
                        create unique index if not exists gift_certificate_id_uindex
                        	on gift_certificate (id);
                        """,
                        """
                        create table if not exists tag
                        (
                        	id bigserial not null
                        		constraint tag_pk
                        			primary key,
                        	name varchar(100)
                        );
                        """,
                        """
                        create unique index if not exists tag_id_uindex
                        	on tag (id);
                        """,
                        """
                        create unique index if not exists tag_name_uindex
                        	on tag (name);
                        """,
                        """
                        create table if not exists gift_tag_mapping
                        (
                        	gc_id bigint
                        		constraint gift_tag_mapping_gift_certificate_id_fk
                        			references gift_certificate,
                        	t_id bigint
                        		constraint gift_tag_mapping_tag_id_fk
                        			references tag
                        );
                        """,
                        """
                         insert into gift_certificate
                         (id, name, description, price,
                         duration, create_date, last_update_time)
                         values (12, 'test', 'desc', 123, 4, null, null)
                        """,
                };
    }
}