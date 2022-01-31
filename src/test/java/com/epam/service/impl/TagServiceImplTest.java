package com.epam.service.impl;

import com.epam.dao.TagDao;
import com.epam.dao.impl.TagDaoImpl;
import com.epam.entity.impl.Tag;
import com.epam.service.TagService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TagServiceImplTest {

    @Mock
    private final TagDao dao = mock(TagDaoImpl.class);

    @InjectMocks
    private final TagService service = new TagServiceImpl(dao);

    private Tag testTag;
    private List<Tag> testList;

    @BeforeEach
    void setUp() {
        testTag = new Tag(123L, "test");
        testList = List.of(testTag);

        when(dao.save(anyString(), any(Tag.class)))
                .thenReturn(true);
        when(dao.find(anyString(), anyLong()))
                .thenReturn(Optional.of(testTag));
        when(dao.find(anyString(), anyString()))
                .thenReturn(Optional.of(testTag));
        when(dao.findAll(anyString())).thenReturn(List.of(testTag));
        when(dao.findAll(anyString(), anyString()))
                .thenReturn(List.of(testTag));
        when(dao.findAll(anyString(), anyLong()))
                .thenReturn(List.of(testTag));
        when(dao.delete(anyString(), anyLong()))
                .thenReturn(true);
    }

    @Test
    void save() {
        assertTrue(service.save(testTag));
    }

    @Test
    void findById() {
        var actual = service
                .findById(151L).orElseThrow();
        assertEquals(testTag, actual);
    }

    @Test
    void findByName() {
        var actual = service
                .findByName("asd").orElseThrow();
        assertEquals(testTag, actual);
    }

    @Test
    void findAll() {
        var actual = service
                .findAll();
        assertEquals(testList, actual);
    }

    @Test
    void update() {
        assertTrue(service.update(testTag));
    }

    @Test
    void deleteById() {
        assertTrue(service.deleteById(1244L));
    }

    @Test
    void findByGiftId() {
        var actual = service
                .findByGiftId(1551L);
        assertEquals(testList, actual);
    }

    @Test
    void findByGiftName() {
        var actual = service
                .findByGiftName("asd");
        assertEquals(testList, actual);
    }
}