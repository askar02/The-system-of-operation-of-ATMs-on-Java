package com.company.repositories.interfaces;

import com.company.entities.Users;

import java.util.List;

public interface IUsersRepo {
    boolean registration(Users users);
    boolean logIn(int login, String password);
}

