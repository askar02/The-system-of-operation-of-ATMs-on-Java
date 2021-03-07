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
    public List<Trans> getAllTransInfo(int card_number) {
        try {
            Connection con = db.getConnection();
            String sql = "select date, type, sum from trans where card_number = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, card_number);
            ResultSet rs = st.executeQuery();
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
    public boolean createTransaction(Trans trans, int card_number) {
        try {
            Connection con = db.getConnection();
            String sql = "insert into trans(date, type, sum, card_number) values(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, trans.getDate());
            st.setString(2, trans.getType());
            st.setInt(3, trans.getSum());
            st.setInt(4, card_number);
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
