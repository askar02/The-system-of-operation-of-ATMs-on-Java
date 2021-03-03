package com.company.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cards {
    private int card_number;
    private String password;
    private String balance;
    private int cvv;
    private int users_login;
    public Cards(){

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
    public static void checkPassword(String password) { // function which cheks the password if it is not matching with conditions outputs come message
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]3)[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            System.out.println("Your password does not match with requirements!\n Please be sure that your password\ncontains at least 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special symbol(@,$,!,^) and length more or equal to 8.");
        }
    }
    public static void idCheck(String ID){
        char [] IDChar = ID.toCharArray();
        boolean firstPart = false;
        boolean secondPart = false;
        for (int i = 0;i < 7; ++i) {
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)) {
                firstPart = true;
            };
        };
        for (int i = 0; i < 7;++i){
            if ((IDChar[i] >= 48 && IDChar[i]<= 59)){
                secondPart = true;
            };
        };
        if (firstPart == true && secondPart == true && IDChar[6] == '-' && ID.length() == 12){
            System.out.println("Your ID is correct");
        };
    };


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
