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
        return Arrays.asList(
                new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));
    }

    static String formatBookList(List<Book> bookList) {
        if (bookList == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder("Books:");

        if (bookList.isEmpty()) {
            return sb.toString();
        }

        for (Book book : bookList) {
            sb.append(System.lineSeparator());
            sb.append(book.getTitle());
        }

        return sb.toString();
    }
}
