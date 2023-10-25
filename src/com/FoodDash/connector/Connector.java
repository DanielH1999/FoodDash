package com.FoodDash.connector;

import java.sql.*;

public class Connector {
    
    public static Connector getConnection()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
        String connection = null;
        String username = null;
        String password = null;
        
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            connection = "jdbc:mysql://127.0.0.1:3306/FoodDash";
            username = "root";
            password = "";
            
            Class.forName(driver).newInstance();
                    
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
            System.out.println(e);
        }
        
        return (Connector) DriverManager.getConnection(connection, username, password);
    }
}
