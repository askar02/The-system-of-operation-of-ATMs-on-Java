package com.company.repositories.interfaces;

import com.company.entities.Users;

import java.util.List;

public interface IUsersRepo {
    boolean registration(Users users); // person can create new user sign up/make registration
    boolean logIn(int login); // user logs in into bank system
}

