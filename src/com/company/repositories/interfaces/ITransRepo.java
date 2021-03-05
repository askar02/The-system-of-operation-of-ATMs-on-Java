package com.company.repositories.interfaces;

import com.company.entities.Trans;

import java.util.List;

public interface ITransRepo {
    List<Trans> getAllTransInfo();
    boolean transPermissionBalance(int id, int balance);
    boolean createTransaction(Trans trans);
}
