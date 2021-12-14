package com.epam.service.impl;

import com.epam.dao.GiftDao;
import com.epam.dao.impl.GiftDaoImpl;
import com.epam.entity.impl.GiftCertificate;
import com.epam.service.GiftService;
import com.epam.util.sorting.impl.GiftSqlSorting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GiftServiceImplTest {

    @Mock
    private final GiftDao dao = mock(GiftDaoImpl.class);

    @InjectMocks
    private final GiftService service = new GiftServiceImpl(dao);

    private GiftCertificate testGift;
    private List<GiftCertificate> testList;

    @BeforeEach
    void setup() {
        testGift = GiftCertificate.newBuilder()
                .setId(1L)
                .setName("Test")
                .setDesc("TestDesc")
                .setPrice(100)
                .setDuration(5)
                .setCreateDate(new Timestamp(System.currentTimeMillis()))
                .setLastUpdateTime(new Timestamp(System.currentTimeMillis()))
                .build();
        testList = List.of(testGift);

        when(dao.save(anyString(), any(GiftCertificate.class)))
                .thenReturn(true);
        when(dao.find(anyString(), anyLong()))
                .thenReturn(Optional.of(testGift));
        when(dao.find(anyString(), anyString()))
                .thenReturn(Optional.of(testGift));
        when(dao.findAll(anyString())).thenReturn(List.of(testGift));
        when(dao.findAll(anyString(), anyString()))
                .thenReturn(List.of(testGift));
        when(dao.findAll(anyString(), anyLong()))
                .thenReturn(List.of(testGift));
        when(dao.update(anyString(), any(GiftCertificate.class)))
                .thenReturn(true);
        when(dao.delete(anyString(), anyLong()))
                .thenReturn(true);
        when(dao.addTagByCertId(anyString(), anyLong(), anyString()))
                .thenReturn(true);
    }

    @Test
    void save() {
        assertTrue(service.save(testGift));
    }

    @Test
    void findById() {
        var actual = service.findById(12L).orElseThrow();
        assertEquals(testGift, actual);
    }

    @Test
    void findByName() {
        var actual = service.findByName("asd").orElseThrow();
        assertEquals(testGift, actual);
    }

    @Test
    void findAll() {
        List<GiftCertificate> actual = service.findAll();
        assertEquals(testList, actual);
    }

    @Test
    void update() {
        assertTrue(service.update(testGift));
    }

    @Test
    void deleteById() {
        assertTrue(service.deleteById(1254L));
    }

    @Test
    void findByTagId() {
        var actual = service.findByTagId(145L);
        assertEquals(testList, actual);
    }

    @Test
    void testFindByTagId() {
        var actual = service
                .findByTagId(16L, GiftSqlSorting.BY_DATE_ASC);
        assertEquals(testList, actual);
    }

    @Test
    void findByTagName() {
        var actual = service.findByTagName("asa");
        assertEquals(testList, actual);
    }

    @Test
    void testFindByTagName() {
        var actual = service
                .findByTagName("asf", GiftSqlSorting.BY_DATE_DESC);
        assertEquals(testList, actual);
    }

    @Test
    void findByPartialName() {
        var actual = service
                .findByPartialName("asf");
        assertEquals(testList, actual);
    }

    @Test
    void testFindByPartialName() {
        var actual = service
                .findByPartialName("asf", GiftSqlSorting.BY_DATE_ASC);
        assertEquals(testList, actual);
    }

    @Test
    void findByPartialDesc() {
        var actual = service
                .findByPartialDesc("asd");
        assertEquals(testList, actual);
    }

    @Test
    void testFindByPartialDesc() {
        var actual = service
                .findByPartialDesc("asd", GiftSqlSorting.BY_NAME_ASC);
        assertEquals(testList, actual);
    }

    @Test
    void addTagToCertificate() {
        assertTrue(service.addTagToCertificate(465L, "asd"));
    }
}