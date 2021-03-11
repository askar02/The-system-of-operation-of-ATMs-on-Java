package com.company.entities;

public class Cards { //instances of cards
    private int card_number;
    private String password;
    private String balance;
    private String cvv;
    private int users_login;

    public Cards(int card_number, String balance, String cvv, int users_login){
        setBalance(balance);
        setCvv(cvv);
        setUsers_login(users_login);
        setCard_number(card_number);
    }

    public Cards(int card_number, String password, String balance, String cvv, int users_login){
        setCard_number(card_number);
        setPassword(password);
        setBalance(balance);
        setCvv(cvv);
        setUsers_login(users_login);
    }

    public Cards(String password, String balance) {
        setCard_number(card_number);
        setPassword(password);
        setBalance(balance);
        setCvv(cvv);
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setUsers_login(int users_login) {
        this.users_login = users_login;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "card_number=" + card_number +
                ", balance='" + balance + '\'' +
                ", cvv='" + cvv + '\'' +
                ", users_login=" + users_login +
                '}';
    }
}
