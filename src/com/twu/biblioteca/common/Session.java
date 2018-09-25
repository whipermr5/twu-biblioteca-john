package com.twu.biblioteca.common;

import java.util.Arrays;
import java.util.List;

public class Session {

    private List<User> users;

    private User currentUser;

    public Session() {
        users = Arrays.asList(
                new User("librarian", "librarian password"),
                new User("valid username", "valid password"),
                new User("000-0000", "0"),
                new User("123-4567", "password"));
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isUserLoggedIn() {
        return currentUser != null;
    }

    public boolean isAdminLoggedIn() {
        return isUserLoggedIn() && getCurrentUser().getUsername().equals("librarian");
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.isPassword(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public boolean logout() {
        if (!isUserLoggedIn()) {
            return false;
        }
        currentUser = null;
        return true;
    }
}
