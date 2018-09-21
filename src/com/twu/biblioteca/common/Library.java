package com.twu.biblioteca.common;

import java.util.Arrays;
import java.util.List;

public class Library {

    private List<Book> books = Arrays.asList(
            new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));

    public List<Book> getAvailableBooks() {
        return books;
    }
}
