package com.company.controllers;

import com.company.entities.Debts;
import com.company.repositories.interfaces.IDebtsRepo;

import java.util.List;

public class DebtsController {
    private final IDebtsRepo repo;
    public DebtsController(IDebtsRepo repo) {
        this.repo = repo;
    }
    public String takeLoan(int loan_sum, int loan_plan, int card_number) { //method of adding new values to a table through repo
        boolean executed = repo.takeLoan(loan_plan, loan_sum, card_number);
        return (executed ? "Loan registration was denied"
                : "Loan is successfully taken. You took " + loan_sum + " for " + loan_plan + " years and will pay " + loan_sum/loan_plan + " per month.");
    } //return string depending on result of method in repo

    public String getAllLoans(int card_number) {//method of accessing all fields on loans table by its card number
        List<Debts> allLoans = repo.getAllLoans(card_number);
        return (allLoans != null ? allLoans.toString() : "Your query is failed. Please try again later.");
    }//return string depending on result of method in repo
}
