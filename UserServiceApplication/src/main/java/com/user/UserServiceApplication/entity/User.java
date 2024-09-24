package com.user.UserServiceApplication.entity;

public class User {
    private Long id;
    private String username; // This should match what is sent from the frontend
    private String password;

    public User() {} // Default constructor needed for JSON deserialization

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() { // Note: This getter should match the frontend's key
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
