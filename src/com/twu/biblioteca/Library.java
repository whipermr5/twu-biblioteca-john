package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

class Library {

    private List<Book> books = Arrays.asList(
            new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));

    List<Book> getBooks() {
        return books;
    }
}
