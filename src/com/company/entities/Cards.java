package com.company.entities;

public class Cards {
    private int card_number;
    private String password;
    private String balance;
    private int cvv;
    private int users_login;
    public Cards(String card_number, String password, int balance, int cvv, int login){

    }

    public Cards(String password, String balance, int cvv, int users_login){
        setPassword(password);
        setBalance(balance);
        setCvv(cvv);
        setUsers_login(users_login);
    }

    public Cards(int card_number, String password, String balance, int cvv, int users_login){
        setCard_number(card_number);
        setPassword(password);
        setBalance(balance);
        setCvv(cvv);
        setUsers_login(users_login);
    }

    public Cards(int card_number, String password, String balance, int cvv) {
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

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getUsers_login() {
        return users_login;
    }

    public void setUsers_login(int users_login) {
        this.users_login = users_login;
    }

}
