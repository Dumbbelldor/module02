package com.epam.util.statement.impl;

import com.epam.entity.impl.GiftCertificate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GiftStateUtilTest {

    @Mock
    private final PreparedStatement statement = mock(PreparedStatement.class);

    private final GiftStateUtil util = GiftStateUtil.INSTANCE;

    private GiftCertificate testGift;

    @BeforeEach
    void setUp() throws SQLException {
        testGift = GiftCertificate.newBuilder().build();
        doNothing().when(statement).setLong(anyInt(), anyLong());
        doNothing().when(statement).setString(anyInt(), anyString());
    }

    @Test
    void fillStatement() throws SQLException {
        assertTrue(util.fillStatement(statement, testGift, false));
    }
}