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
        try {
            Connection con = db.getConnection();
            String sql = "INSERT INTO users(login,fname,lname,birth_date) VALUES (?,?,?,?)"; //inserting data to developers table
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, users.getLogin());
            st.setString(2, users.getFname());
            st.setString(3, users.getLname());
            st.setString(4, users.getBirth_date());

            boolean executed = st.execute();
            con.close();
            return executed;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            }
        return true;
    }

    @Override
    public boolean logIn(int login) {
        try {
            Connection con = db.getConnection();
            String sql = "SELECT login FROM users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Integer> logins = new ArrayList<>();
            while(rs.next()) {
                int login1 = rs.getInt("login");
                logins.add(login1);
                con.close();
                for (int login2:logins) {
                    if (login2 == login1) {
                        return true;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
