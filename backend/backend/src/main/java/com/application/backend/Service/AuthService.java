package com.application.backend.service;

import com.application.backend.entity.User;
import com.application.backend.dto.LoginRequest;
import com.application.backend.dto.RegisterRequest;
import com.application.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public String register(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email already exists!";
        }

        userRepository.save(user);
        return "User registered successfully!";
    }

    // Login user
    public String login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return "User not found!";
        }

        if (!user.getPassword().equals(password)) {
            return "Incorrect password!";
        }

        return "Login successful!";
    }
}
