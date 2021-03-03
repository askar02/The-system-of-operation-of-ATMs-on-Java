package com.company.data;
import com.company.data.interfaces.IDB;

import java.sql.*;
public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            String connectionUrl = "jdbc:postgresql://localhost:5432/bankcompany";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "04992003");
            return con;
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            throw e;
        }
    }
}