package com.application.backend.controller;

import com.application.backend.dto.LoginRequest;
import com.application.backend.dto.RegisterRequest;
import com.application.backend.entity.User;
import com.application.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Register
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = new User(request.getUsername(), request.getEmail(), request.getPassword());
        return authService.register(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request.getEmail(), request.getPassword());
    }
}
