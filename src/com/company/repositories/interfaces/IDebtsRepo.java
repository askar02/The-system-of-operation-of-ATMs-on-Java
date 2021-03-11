package com.company.repositories.interfaces;

import com.company.entities.Debts;

import java.util.List;

public interface IDebtsRepo {
    boolean takeLoan(int loan_plan, int loan_sum, int card_number); //takeLoan is menu by which user can take new loan based on time, sum, and number of card
    List<Debts> getAllLoans(int card_number); // by this menu user can see all loans which he/she has on current time
}
