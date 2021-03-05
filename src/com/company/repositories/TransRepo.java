package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Trans;
import com.company.repositories.interfaces.ITransRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransRepo implements ITransRepo {
    private final IDB db;
    public TransRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean transPermissionBalance(int id, int balance) {
        try {
            Connection con = db.getConnection();
            String sql = "select trans.sum, cards.balance from trans inner join cards on cards.card_number = trans.card_number where trans.id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int sum1 = rs.getInt("trans.sum");
                String balance1 = rs.getString("balance");
                int balance2 = Integer.parseInt(balance1);
                if (sum1<=balance2) {
                    return true;
                }
            }
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Trans> getAllTransInfo() {
        try {
            Connection con = db.getConnection();
            String sql = "select date, type, sum from trans";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Trans> transList = new ArrayList<>();
            while (rs.next()) {
                Trans trans = new Trans(rs.getString("date"),
                        rs.getString("type"),
                        rs.getInt("sum"));
                transList.add(trans);
                con.close();
            }
            return transList;
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createTransaction(Trans trans) {
        try {
            Connection con = db.getConnection();
            String sql = "insert into trans(date, type, sum) values(?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, trans.getDate());
            st.setString(2, trans.getType());
            st.setInt(3, trans.getSum());
            boolean executed = st.execute();
            con.close();
            return  executed;
            }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
