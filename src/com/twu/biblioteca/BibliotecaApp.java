package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(welcome());
        System.out.println(listBooks());
    }

    static String welcome() {
        return "Welcome!";
    }

    static String listBooks() {
        return "Books:";
    }
}
