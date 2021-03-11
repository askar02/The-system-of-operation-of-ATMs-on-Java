package com.company.entities;

public class Cards {
    private int card_number; //variable
    private String password; //variable
    private String balance; //variable
    private String cvv; //variable
    private int users_login; //variable

    public Cards(int card_number, String balance, String cvv, int users_login){ //method which named Cards
        setBalance(balance);
        setCvv(cvv);
        setUsers_login(users_login);
        setCard_number(card_number);
    }

    public Cards(int card_number, String password, String balance, String cvv, int users_login){ //Cards method
        setCard_number(card_number);
        setPassword(password);
        setBalance(balance);
        setCvv(cvv);
        setUsers_login(users_login);
    }

    public Cards(String password, String balance) { //method
        setCard_number(card_number);
        setPassword(password);
        setBalance(balance);
        setCvv(cvv);
    }

    public int getCard_number() {
        return card_number;
    } //Method, which returns card_number of card

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    } //Method, which changes the card_number of card

    public String getPassword() {
        return password;
    } //Method, which returns password of card

    public void setPassword(String password) {
        this.password = password;
    } //Method, which changes the password of card

    public String getBalance() {
        return balance;
    } //Method, which returns balance of card

    public void setBalance(String balance) {
        this.balance = balance;
    }//Method, which changes the balance of card

    public String getCvv() {
        return cvv;
    } //Method, which returns cvv of card

    public void setCvv(String cvv) {
        this.cvv = cvv;
    } //Method, which changes the cvv of card

    public void setUsers_login(int users_login) {
        this.users_login = users_login;
    } //Method, which changes the users_login of card

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
