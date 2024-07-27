package com.zharnikova.example;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DataSource.class})
 class MyTest {

    private HikariDataSource mockedDataSource;
    private Connection mockedConnection;

    @Before
    public void setUp() throws Exception {
        mockedDataSource = PowerMockito.mock(HikariDataSource.class);
        mockedConnection = PowerMockito.mock(Connection.class);

        PowerMockito.whenNew(HikariDataSource.class).withAnyArguments().thenReturn(mockedDataSource);
        when(mockedDataSource.getConnection()).thenReturn(mockedConnection);
    }

    @Test
     void testGetConnection() throws SQLException {
        PowerMockito.mockStatic(DataSource.class);

        Connection connection = DataSource.getConnection();
        assertNotNull(connection);
        Mockito.verify(mockedDataSource).getConnection();
    }
}