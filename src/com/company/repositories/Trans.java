package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.repositories.interfaces.ITrans;

import java.sql.*;

public class Trans implements ITrans {
    private final IDB db;
    public Trans(IDB db) {
        this.db = db;
    }

    @Override
    public boolean executeTrans(int id, int cvv) {
        try {
            Connection con = db.getConnection();
            String sql = "select cvv from card where id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            st.setInt(1, id);
            if (rs.next()) {
                int cvv1 = rs.getInt("cvv");
                if (cvv1 == cvv) {
                    return true;
                }
            }
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
