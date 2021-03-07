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
            Connection con = db.getConnection();
            String sql = "select* from debts where card_number = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, card_number);
            ResultSet rs = st.executeQuery();
            List<Debts> debtsList = new ArrayList<>();
            while (rs.next()) {
                Debts debt = new Debts(rs.getInt("loan_sum"),
                        rs.getInt("loan_plan"));
                debtsList.add(debt);
                con.close();
            }
            return debtsList;
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean takeLoan(int loan_plan, int loan_sum, int card_number) {
        try {
            Connection con = db.getConnection();
            String sql = "insert into debts(loan_plan, loan_sum, card_number) values (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, loan_plan);
            st.setInt(2, loan_sum);
            st.setInt(3, card_number);
            boolean taken = st.execute();
            con.close();
            return taken;
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}