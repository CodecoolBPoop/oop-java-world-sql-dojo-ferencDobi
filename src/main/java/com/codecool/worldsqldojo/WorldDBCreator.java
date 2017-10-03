package com.codecool.worldsqldojo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.SQLTimeoutException;
import java.sql.SQLException;

public class WorldDBCreator {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/world";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public PreparedStatement getPreparedStatement(String query) {
        try (Connection conn =
             DriverManager.getConnection(DATABASE,
                                         DB_USER,
                                         DB_PASSWORD)){
            return conn.prepareStatement(query);
        } catch (SQLTimeoutException e) {
            System.err.println("ERROR: SQL Timeout");
        } catch (SQLException e) {
        }
        return null;
    }

    public void executeQuery(PreparedStatement statement) throws SQLException {
        statement.execute();
    }
}
