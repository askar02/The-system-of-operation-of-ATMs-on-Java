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
        try {
            Connection con = db.getConnection();
            String sql = "INSERT INTO cards(card_number,password,balance,cvv,login) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, cards.getCard_number());
            st.setString(2, cards.getPassword());
            st.setString(3, cards.getBalance());
            st.setInt(4, cards.getCvv());
            st.setInt(5, cards.getUsers_login());
            boolean executed = st.execute();
            con.close();
            return executed;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Cards> viewAllCards() {
        try {
            Connection con = db.getConnection();
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
                con.close();
            }
            return cards;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Cards getCard(int cardNumber) {
        try {
            Connection con = db.getConnection();
            String sql = "select (card_number, password, balance, cvv) from cards where card_number = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cardNumber);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cards cards = new Cards(rs.getInt("card_number"),
                        rs.getString("password"),
                        rs.getString("balance"),
                        rs.getInt("cvv"));
                con.close();
                return cards;
            }
        }
        catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
