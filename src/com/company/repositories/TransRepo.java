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
            Connection con = db.getConnection();//establish connection with DB
            String sql = "select date, type, sum from trans where card_number = ?";//statement of sql to access fields of table through PK
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, card_number);//set given number
            ResultSet rs = st.executeQuery();
            List<Trans> transList = new ArrayList<>();//list to keep all transactions
            while (rs.next()) {
                Trans trans = new Trans(rs.getString("date"),//creation of instances fo transaction to pass to to list
                        rs.getString("type"),
                        rs.getInt("sum"));
                transList.add(trans);//add object to list
                con.close();//close connection
            }
            return transList;//return list
        }
        catch (SQLException | ClassNotFoundException throwable) {//catch exceptions
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createTransaction(Trans trans, int card_number) {
        try {
            Connection con = db.getConnection();//establish connection
            String sql = "insert into trans(date, type, sum, card_number) values(?, ?, ?, ?)";//sql statement
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, trans.getDate());//set given numbers to get access
            st.setString(2, trans.getType());
            st.setInt(3, trans.getSum());
            st.setInt(4, card_number);
            boolean executed = st.execute();//boolean to check whether statement is exeuted or not
            con.close();//close connection
            return  executed;//return boolean
            }
        catch (SQLException | ClassNotFoundException throwable) {//catch exceptions
            throwable.printStackTrace();
        }
        return false;
    }
}
