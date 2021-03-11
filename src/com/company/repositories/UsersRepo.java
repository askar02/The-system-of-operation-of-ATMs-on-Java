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
            Connection con = db.getConnection();//establish connection with DB
            String sql = "INSERT INTO users(login,fname,lname,birth_date) VALUES (?,?,?,?)"; //sql statement to insert data to the table
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, users.getLogin());//set given numbers/strings
            st.setString(2, users.getFname());
            st.setString(3, users.getLname());
            st.setString(4, users.getBirth_date());

            boolean executed = st.execute();//boolean to check whether statement is executed or not
            con.close();//close connection
            return executed;//return boolean
        } catch (SQLException | ClassNotFoundException throwables) {//catch exceptions
            throwables.printStackTrace();
            }
        return true;
    }

    @Override
    public boolean logIn(int login) {
        try {
            Connection con = db.getConnection();//establish connection with DB
            String sql = "SELECT login FROM users";//sql statement to get all logins of users
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Integer> logins = new ArrayList<>();//list to keep all logins of users
            while(rs.next()) {
                int login1 = rs.getInt("login"); //instance of new login
                logins.add(login1);//pass it to the list
                con.close();//close connection
                for (int login2:logins) {//check login with every member of list
                    if (login2 == login) {
                        return true; //if they are equal/ return true
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {//catch exceptions
            throwables.printStackTrace();
        }
        return false;
    }

}
