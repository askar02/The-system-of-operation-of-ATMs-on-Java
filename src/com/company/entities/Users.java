package com.company.entities;

public class Users { //instances of Users objects
    private int login;
    private String fname;
    private String lname;
    private String birth_date;

    public Users(int login, String fname, String lname, String birth_date) {
        setFname(fname);
        setLname(lname);
        setBirth_date(birth_date);
        setLogin(login);
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }


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

