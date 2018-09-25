package com.twu.biblioteca.common;

public class User {

    private String username;
    private String password;
    private String name;
    private String email;
    private int number;

    public User(String username, String password, String name, String email, int number) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    boolean isPassword(String password) {
        return password.equals(this.password);
    }
}
