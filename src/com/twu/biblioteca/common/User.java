package com.twu.biblioteca.common;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPassword(String password) {
        return password.equals(this.password);
    }
}