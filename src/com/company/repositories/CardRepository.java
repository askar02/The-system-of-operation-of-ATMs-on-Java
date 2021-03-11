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
    public boolean createNewCard(Cards cards, int login) {
        try {
            Connection con = db.getConnection();//establish connection with DB
            String sql = "INSERT INTO cards(card_number,password,balance,cvv,login) VALUES (?,?,?,?,?)";//sql statement to insert values
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, cards.getCard_number());//set given values
            st.setString(2, cards.getPassword());
            st.setString(3, cards.getBalance());
            st.setString(4, cards.getCvv());
            st.setInt(5, login);
            boolean executed = st.execute();//boolean to check whether statement is executed or not
            con.close();//close connection
            return executed;//return boolean
        } catch (SQLException | ClassNotFoundException throwables) {//catch exceptions
            throwables.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Cards> viewAllCards(int login) {
        try {
            Connection con = db.getConnection();//establish connection with D
            String sql = "SELECT card_number,balance,cvv,login FROM cards where login = ?";//sql statement to access values
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, login);//set login
            ResultSet rs = st.executeQuery();
            List<Cards> cards = new ArrayList<>();//list to keep all cards
            while (rs.next()) {
                Cards card = new Cards(rs.getInt("card_number"),//object that keeps some values
                        rs.getString("balance"),
                        rs.getString("cvv"),
                        rs.getInt("login"));

                cards.add(card);//pass object to list
                con.close();//close connection
            }
            return cards;//return list
        } catch (SQLException | ClassNotFoundException throwables) {//catch exceptions
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Cards getCard(int cardNumber, int login) {
        try {
            Connection con = db.getConnection();//establish connection with DB
            String sql = "select * from cards where card_number = ?";//sql statement to access values
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cardNumber);//set given values
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Cards cards = new Cards(rs.getInt("card_number"),//object that keeps some values
                        rs.getString("password"),
                        rs.getString("balance"),
                        rs.getString("cvv"),
                        rs.getInt("login"));
                con.close();//close connection
                return cards;//return object
            }
        } catch (SQLException | ClassNotFoundException throwable) {//catch exceptions
            throwable.printStackTrace();
        }
        return null;
    }
}
