package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Cards;
import com.company.repositories.interfaces.ICardRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardRepository implements ICardRepo {
    private final IDB db;

    public CardRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createNewCard(Cards cards) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO cards(card_number,password,balance,cvv,login) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, cards.getCard_number());
            st.setString(2, cards.getPassword());
            st.setString(3, cards.getBalance());
            st.setInt(4, cards.getCvv());
            st.setInt(5, cards.getUsers_login());
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
        return false;
    }
    @Override
    public List<Cards> viewAllCards() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT card_number,password,balance,cvv,login FROM cards";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Cards> cards = new ArrayList<>();
            while (rs.next()) {
                Cards card = new Cards(rs.getString("card_number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getInt("cvv"),
                        rs.getInt("login"));

                cards.add(card);
            }

            return cards;
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
        return null;
    }
}
