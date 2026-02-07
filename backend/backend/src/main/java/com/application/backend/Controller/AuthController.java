package com.application.backend.Controller;

import com.application.backend.Entity.User;
import com.application.backend.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> request){
        User user = authService.register(
                request.get("username"),
                request.get("email"),
                request.get("password")
        );

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("username", user.getUsername());
        response.put("email", user.getEmail());
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request){
        User user = authService.login(
                request.get("email"),
                request.get("password")
        );

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("username", user.getUsername());
        response.put("email", user.getEmail());
        return response;
    }
}
