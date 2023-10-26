package com.FoodDash.connector;

import java.sql.*;

public class Connector {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/FoodDash";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
