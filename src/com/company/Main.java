package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;


public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
    }
}