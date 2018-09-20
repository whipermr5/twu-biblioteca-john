package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(welcome());
        System.out.println(formatBookList(listBooks()));
    }

    static String welcome() {
        return "Welcome!";
    }

    static List<Book> listBooks() {
        return Arrays.asList(new Book("TDD"), new Book("Refactoring"));
    }

    private static String formatBookList(List<Book> bookList) {
        return "Books:\nTDD\nRefactoring";
    }
}
