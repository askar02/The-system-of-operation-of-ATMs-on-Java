package com.company.controllers;

import com.company.entities.Trans;
import com.company.repositories.interfaces.ITransRepo;

import java.util.List;

public class TransController {
    private final ITransRepo repo;
    public TransController(ITransRepo repo) {
        this.repo = repo;
    }
    public String getAllTransInfo() {
        List<Trans> transList = repo.getAllTransInfo();
        return transList.toString();
    }
    public String createTransaction(int sum, String date, String type, int card_id, String cvv, int balance, int trans_id) {
        Trans trans = new Trans(date, type, sum);
        boolean created = repo.createTransaction(trans);
        boolean balancePermission = repo.transPermissionBalance(trans_id, balance);
        return ((created || balancePermission) ? "Transaction is successfully finished!" : "Transaction is failed!");
    }
}
