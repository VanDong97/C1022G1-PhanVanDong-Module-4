package com.example.registration_form.service.impl;

import com.example.registration_form.model.User;
import com.example.registration_form.repository.IUserRepository;
import com.example.registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> listAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        iUserRepository.save(user);
    }
}
