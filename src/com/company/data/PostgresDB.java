package com.company.data;
import com.company.data.interfaces.IDB;

import java.sql.*;
public class PostgresDB implements IDB { //class implements all methods from IDB
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            String connectionUrl = "jdbc:postgresql://localhost:5432/postgres"; // url connection to DataBase
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "12345"); // username and password to work with database
            return con;
        }
        catch (SQLException | ClassNotFoundException e) { //catch any exception
            System.out.println(e); // output the result of exception of any
            throw e;
        }
    }
}