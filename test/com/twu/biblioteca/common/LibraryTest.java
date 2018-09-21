package com.twu.biblioteca.common;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LibraryTest {

    private static Library library;
    private static Book firstBook;
    private static Book secondBook;

    @Before
    public void setUpLibrary() {
        library = new Library();
        List<Book> books = library.getAvailableBooks();
        firstBook = books.get(0);
        secondBook = books.get(1);
    }

    @Test
    public void testGetAvailableBooks() {
        List<Book> originalBooks = library.getAvailableBooks();

        firstBook.setOwner("user");

        assertTrue(originalBooks.contains(firstBook));
        assertFalse(library.getAvailableBooks().contains(firstBook));
    }

    @Test
    public void testCheckout() {
        assertTrue(library.getAvailableBooks().contains(firstBook));
        assertTrue(library.getAvailableBooks().contains(secondBook));
        assertTrue(library.checkout(firstBook.getId(), "user"));
        assertFalse(library.getAvailableBooks().contains(firstBook));

        assertTrue(library.getAvailableBooks().contains(secondBook));
        assertTrue(library.checkout(secondBook.getId(), "user"));
        assertFalse(library.getAvailableBooks().contains(firstBook));
        assertFalse(library.getAvailableBooks().contains(secondBook));

        assertFalse(library.checkout(secondBook.getId(), "user"));
    }
}
