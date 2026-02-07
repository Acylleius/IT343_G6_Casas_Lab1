package com.application.backend.Service;

import com.application.backend.Entity.User;
import com.application.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public User register(String username, String email, String password){
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email already exists");
        }
        if(userRepository.existsByUsername(username)){
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // store as plain text for now

        return userRepository.save(user);
    }

    // Login user
    public User login(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }
}
