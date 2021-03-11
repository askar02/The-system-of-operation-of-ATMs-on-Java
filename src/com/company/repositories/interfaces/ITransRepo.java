package com.company.repositories.interfaces;

import com.company.entities.Trans;

import java.util.List;

public interface ITransRepo {
    List<Trans> getAllTransInfo(int card_number); //this menu represents information about all completed transactions(history)
    boolean createTransaction(Trans trans, int card_number); //creates new transaction based on the card number and type of transaction
}
