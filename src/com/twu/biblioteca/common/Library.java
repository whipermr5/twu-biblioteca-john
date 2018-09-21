package com.twu.biblioteca.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Book> books = Arrays.asList(
            new Book("TDD", "Kent", 2002), new Book("Refactoring", "Martin", 1999));

    public List<Book> getAvailableBooks() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public boolean checkout(int bookId, String ownerId) {
        for (Book book : getAvailableBooks()) {
            if (book.getId() == bookId) {
                book.setOwner(ownerId);
                return true;
            }
        }
        return false;
    }
}
