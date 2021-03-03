package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Users;
import com.company.repositories.interfaces.IUsersRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepo implements IUsersRepo {
    private final IDB db;

    public UsersRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean registration(Users users) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(login,fname,lname,birth_date) VALUES (?,?,?,?)"; //inserting data to developers table
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, users.getLogin());
            st.setString(2, users.getFname());
            st.setString(3, users.getLname();
            st.setString(4, users.getBirth_date();

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean login(int login, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT login FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int login1 = rs.getInt("login");
                String password1 = rs.getString("password");
                if (login1 == login){
                    if (password1.equals(password)){
                        return true;
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

}
