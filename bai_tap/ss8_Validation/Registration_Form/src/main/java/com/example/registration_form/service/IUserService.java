package com.example.registration_form.service;

import com.example.registration_form.model.User;

import java.util.List;

public interface IUserService {

    List<User> listAll();

    void createUser(User user);
}
