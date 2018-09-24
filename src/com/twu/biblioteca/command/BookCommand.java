package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;

import java.util.List;
import java.util.stream.Collectors;

abstract class BookCommand extends Command {

    static List<Book> getAvailableBooks(Library library) {
        return library.getAvailableItems().stream().filter(item -> item instanceof Book).map(Book.class::cast)
                .collect(Collectors.toList());
    }

    static List<Book> getBooksBorrowedBy(Library library, String borrowerId) {
        return library.getItemsBorrowedBy(borrowerId).stream()
                .filter(item -> item instanceof Book).map(Book.class::cast)
                .collect(Collectors.toList());
    }

    static boolean isBook(Item item) {
        return item instanceof Book;
    }
}
