package com.codecool.worldsqldojo;

import java.sql.*;

public class WorldDBCreator {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/world";
    private static final String DB_USER = System.getenv("POSTGRES_DB_USER");
    private static final String DB_PASSWORD = System.getenv("POSTGRES_DB_PASSWORD");

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

    public ResultSet executeQuery(PreparedStatement statement) throws SQLException {
        return statement.executeQuery();
    }
}
