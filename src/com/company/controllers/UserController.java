package com.company.controllers;

import com.company.entities.Users;
import com.company.repositories.interfaces.IUsersRepo;

public class UserController {
    private final IUsersRepo repo;
    public UserController(IUsersRepo repo) {
        this.repo = repo;
    }
    public String registration(int login, String fname, String lname, String birth_date) {
        Users users = new Users(login, fname, lname, birth_date);
        boolean executed = repo.registration(users);
        return (executed ? "Registration is failed. Please try again" : "Registration is successful.");
    }

    public boolean logIn(int login) {
        return repo.logIn(login);
    }
}
