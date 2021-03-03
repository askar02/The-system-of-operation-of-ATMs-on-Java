package com.company.repositories.interfaces;

import com.company.entities.Trans;

import java.util.List;

public interface ITransRepo {
    boolean transPermissionCVV(int id, String cvv);
    List<Trans> getAllTransInfo();
    boolean transPermissionBalance(int id, int balance);
    boolean createTransaction(Trans trans);
}
