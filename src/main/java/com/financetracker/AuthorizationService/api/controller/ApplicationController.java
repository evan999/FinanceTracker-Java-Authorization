package com.financetracker.AuthorizationService.api.controller;

import com.financetracker.AuthorizationService.api.model.User;
import com.financetracker.AuthorizationService.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ApplicationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/user/register")
    public String registerUser(@RequestBody User user){
        String password=user.getPassword();
        String encryptPassword = passwordEncoder.encode(password);
        user.setPassword(encryptPassword);
        userRepository.save(user);
        return "User registered successfully";
    }




}
