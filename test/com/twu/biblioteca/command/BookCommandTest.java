package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookCommandTest {

    private static Library library;
    private static Book firstItem;

    @Before
    public void setUp() {
        library = new Library();
        firstItem = (Book) library.getAvailableItems().get(0);
        library.checkoutItem(firstItem.getId(), "user");
    }

    @Test
    public void testGetAvailableBooks() {
        assertFalse(BookCommand.getAvailableBooks(library).contains(firstItem));
        List<Book> expected = library.getAvailableItems().stream()
                .filter(item -> item instanceof Book).map(Book.class::cast).collect(Collectors.toList());
        assertEquals(expected, BookCommand.getAvailableBooks(library));
    }

    @Test
    public void testGetBooksBorrowedBy() {
        assertEquals(Collections.singletonList(firstItem), BookCommand.getBooksBorrowedBy(library, "user"));
    }

    @Test
    public void testIsBook() {
        assertTrue(BookCommand.isBook(firstItem));
        assertFalse(BookCommand.isBook(new Movie(null, 0, null, null)));
    }
}
