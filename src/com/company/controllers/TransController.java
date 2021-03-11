package com.company.controllers;

import com.company.entities.Trans;
import com.company.repositories.interfaces.ITransRepo;

import java.util.List;

public class TransController {
    private final ITransRepo repo;
    public TransController(ITransRepo repo) {
        this.repo = repo;
    }
    public String getAllTransInfo(int card_number) {
        List<Trans> transList = repo.getAllTransInfo(card_number);
        return transList.toString();
    }
    public String createTransaction(int sum, String date, String type, int card_number) {
        Trans trans = new Trans(date, type, sum);
        boolean created = repo.createTransaction(trans, card_number);
        return (created ?  "Transaction is failed!": "Transaction is successfully finished!" );
    }
}
