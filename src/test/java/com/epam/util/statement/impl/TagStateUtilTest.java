package com.epam.util.statement.impl;

import com.epam.entity.impl.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TagStateUtilTest {

    @Mock
    private final PreparedStatement statement = mock(PreparedStatement.class);

    private final TagStateUtil util = new TagStateUtil();

    private Tag testTag;

    @BeforeEach
    void setup() throws SQLException {
        testTag = new Tag(123L, "sad");
        doNothing().when(statement).setLong(anyInt(), anyLong());
        doNothing().when(statement).setString(anyInt(), anyString());
    }

    @Test
    void fillStatement1() throws SQLException {
        assertTrue(util.fillStatement(statement, testTag));
    }
}