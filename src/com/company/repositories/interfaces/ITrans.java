package com.company.repositories.interfaces;

public interface ITrans {
    boolean executeTrans(int id, int cvv);
    String operation();
}
