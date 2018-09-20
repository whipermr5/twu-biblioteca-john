package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(welcome());
        System.out.println(listBooks());
    }

    private static String welcome() {
        return "Welcome!";
    }

    private static String listBooks() {
        return "Books:";
    }
}
