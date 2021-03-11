package com.company.entities;

public class Users {
    private int login; //variable
    private String fname;//variable
    private String lname;//variable
    private String birth_date;//variable

    public Users(int login, String fname, String lname, String birth_date) { //Users method
        setFname(fname);
        setLname(lname);
        setBirth_date(birth_date);
        setLogin(login);
    }

    public int getLogin() {
        return login;
    } //Method, which returns login of users

    public void setLogin(int login) {
        this.login = login;
    } //Method, which changes the login of users

    public String getFname() {
        return fname;
    } //Method, which returns fname of users

    public void setFname(String fname) {
        this.fname = fname;
    } //Method, which changes the fname of users

    public String getLname() {
        return lname;
    } //Method, which returns lname of users

    public void setLname(String lname) {
        this.lname = lname;
    } //Method, which changes the lname of users

    public String getBirth_date() {
        return birth_date;
    } //Method, which returns birth_date of users

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    } //Method, which changes the birth_date of users


    @Override
    public String toString() {
        return "User{" +
                "login=" + login +
                ", first name='" + fname + '\'' +
                ", last name='" + lname + '\'' +
                ", Date of birth=" + birth_date +
                '}';
    }
}

