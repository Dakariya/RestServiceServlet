package com.zharnikova.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;


import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
@PrepareForTest(DataSource.class)
class DataSourceTest {

    @Mock
    private HikariDataSource mockedDataSource;

    @Mock
    private Connection mockedConnection;

    @BeforeEach
    void setUp() throws Exception {
        PowerMockito.mockStatic(DataSource.class);
        when(DataSource.getConnection()).thenReturn(mockedConnection);
        when(DataSource.createDataSource()).thenReturn(mockedDataSource);
    }

}




