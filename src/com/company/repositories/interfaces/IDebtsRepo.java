package com.company.repositories.interfaces;

import com.company.entities.Debts;

import java.util.List;

public interface IDebtsRepo {
    boolean takeLoan(int loan_plan, int loan_sum);
    List<Debts> getAllLoans();
}
