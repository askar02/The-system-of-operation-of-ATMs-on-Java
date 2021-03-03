package com.company.entities;

public class Debts {
    private int card_number;
    private int loan_plan;
    private boolean loans;

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public int getLoan_plan() {
        return loan_plan;
    }

    public void setLoan_plan(int loan_plan) {
        this.loan_plan = loan_plan;
    }

    public boolean isLoans() {
        return loans;
    }

    public void setLoans(boolean loans) {
        this.loans = loans;
    }
}