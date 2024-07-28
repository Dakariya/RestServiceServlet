package com.zharnikova.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MyApp {
    public static void main(String[] args) throws SQLException {
        try {
            File file = new File("src/main/java/com/zharnikova/example/sql/schema.sql");
            byte[] content = Files.readAllBytes(file.toPath());
            String sql = new String(content, StandardCharsets.UTF_8);

            // Split the SQL script into individual statements
            String[] sqlStatements = sql.split(";");

            // Establish a database connection
            try (Connection connection = DataSource.getConnection();
                 Statement statement = connection.createStatement()) {

                // Execute each SQL statement
                for (String sqlStatement : sqlStatements) {
                    if (!sqlStatement.trim().isEmpty()) {
                        statement.execute(sqlStatement);
                    }
                }
                System.out.println("SQL script executed successfully.");

            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("SQL execution failed: " + e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read the SQL file: " + e.getMessage(), e);
        }
    }
}
