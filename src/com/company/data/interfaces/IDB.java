package com.company.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB { // interface for db
    Connection getConnection() throws SQLException, ClassNotFoundException;
}