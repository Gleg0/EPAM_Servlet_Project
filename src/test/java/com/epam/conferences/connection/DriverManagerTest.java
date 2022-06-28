package com.epam.conferences.connection;

import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerTest {
    @Test
    public void testConnection() throws SQLException {
        DriverManager.getConnection("jdbc:postgresql://localhost/epam_spring_project","postgres","root");
    }
}
