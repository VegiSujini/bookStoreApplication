package com.user.UserServiceApplication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.UserServiceApplication.entity.User;
import com.user.UserServiceApplication.service.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/api/authenticate")
    public String authenticate(@RequestBody User user) {
        System.out.println("Received Username: " + user.getUserName());
        System.out.println("Received Password: " + user.getPassword());

        if ("user".equals(user.getUserName()) && "password".equals(user.getPassword())) {
            return jwtUtil.generateToken(user.getUserName());
        }
        throw new RuntimeException("Invalid credentials");
    }

}
