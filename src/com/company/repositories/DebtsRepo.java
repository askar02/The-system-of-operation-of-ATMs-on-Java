package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Debts;
import com.company.repositories.interfaces.IDebtsRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DebtsRepo implements IDebtsRepo {
    private final IDB db;
    public DebtsRepo(IDB db) {
        this.db = db;
    }

    @Override
    public List<Debts> getAllLoans(int card_number) {
        try {
            Connection con = db.getConnection(); //establish connection
            String sql = "select* from debts where card_number = ?"; //sql statement to access all fields of table
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, card_number); //set given number
            ResultSet rs = st.executeQuery();
            List<Debts> debtsList = new ArrayList<>(); //list to keep all fields of table
            while (rs.next()) {
                Debts debt = new Debts(rs.getInt("loan_sum"),
                        rs.getInt("loan_plan"));
                debtsList.add(debt);
                con.close(); //close connection
            }
            return debtsList; //return list
        }
        catch (SQLException | ClassNotFoundException throwable) { //catch exceptions
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean takeLoan(int loan_plan, int loan_sum, int card_number) {
        try {
            Connection con = db.getConnection();//establish connection with DB
            String sql = "insert into debts(loan_plan, loan_sum, card_number) values (?, ?, ?)";//sql statement to access fields of table
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, loan_plan); //set given numbers
            st.setInt(2, loan_sum);
            st.setInt(3, card_number);
            boolean taken = st.execute();//boolean to check if statement executed or not
            con.close();//close connection
            return taken; //return boolean
        }
        catch (SQLException | ClassNotFoundException throwable) {//catch exception
            throwable.printStackTrace();
        }
        return false;
    }
}