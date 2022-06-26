package com.epam.conferences.repository.conection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface of connection pool.<br>
 * Declares base pool functionality.<br>
 * */
public interface ConnectionPool {
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
}
