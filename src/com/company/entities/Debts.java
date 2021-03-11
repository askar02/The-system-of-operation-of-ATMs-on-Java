package com.company.entities;

public class Debts {
    private int card_number; //variable
    private int loan_plan, loan_sum; //variable

    public Debts(int loan_sum, int loan_plan) { //Debts method
        setLoan_plan(loan_plan);
        setLoan_sum(loan_sum);
    }

    public int getCard_number() {
        return card_number;
    } //Method, which returns card_number of card

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    } //Method, which changes the card_number of card

    public int getLoan_plan() {
        return loan_plan;
    } //Method, which returns loan_plan of card

    public void setLoan_plan(int loan_plan) {
        this.loan_plan = loan_plan;
    } //Method, which changes the loan_plan of debts

    public int getLoan_sum() {
        return loan_sum;
    } //Method, which returns loan_sum of debts

    public void setLoan_sum(int loan_sum) {
        this.loan_sum = loan_sum;
    } //Method, which changes the loan_sum of debts

    @Override
    public String toString() {
        return "Debts{" +
                ", loan_plan=" + loan_plan +
                ", loan_sum=" + loan_sum +
                '}';
    }
}