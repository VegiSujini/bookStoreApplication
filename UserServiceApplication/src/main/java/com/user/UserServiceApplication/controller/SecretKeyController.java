package com.user.UserServiceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretKeyController {

    @Autowired
    private Environment env;

    @GetMapping("/show-secret")
    public String showSecret() {
        // Fetch the secret key directly from the environment
        String jwtSecret = env.getProperty("jwt.secret", "NOT_FOUND");
        return "JWT Secret Key: " + jwtSecret;
    }
}
