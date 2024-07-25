package com.zharnikova.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "E65@pop3!";
    private static Connection connection;

    public static Connection instance() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(JDBC_URL,
                        JDBC_USERNAME,
                        JDBC_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
