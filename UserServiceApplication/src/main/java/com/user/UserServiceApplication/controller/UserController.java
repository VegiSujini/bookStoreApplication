package com.user.UserServiceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.UserServiceApplication.entity.User;
import com.user.UserServiceApplication.service.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Ensure this matches your frontend URL
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    // Placeholder for real user validation (replace this with actual user validation)
    private boolean validateUser(String username, String password) {
        // For demonstration purposes: replace with real authentication logic (e.g., check against database)
        return "user".equals(username) && "password".equals(password);
    }

    @PostMapping("/api/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User user) {
        // Debugging input values to ensure consistency
        System.out.println("Received Username: " + user.getUsername());
        System.out.println("Received Password: " + user.getPassword());

        // Replace this simple check with a proper user validation method
        if (validateUser(user.getUsername(), user.getPassword())) {
            // Generate the JWT token upon successful authentication
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        }

        // Throw a custom exception for invalid credentials
        throw new RuntimeException("Invalid credentials");
    }

    // Handle exceptions gracefully and send a structured JSON response
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("{\"error\": \"" + ex.getMessage() + "\"}");
    }
}
