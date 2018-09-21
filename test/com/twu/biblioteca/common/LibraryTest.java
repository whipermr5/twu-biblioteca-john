package com.twu.biblioteca.common;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LibraryTest {

    @Test
    public void testGetAvailableBooks() {
        Library library = new Library();
        List<Book> originalBooks = library.getAvailableBooks();

        Book firstBook = originalBooks.iterator().next();
        firstBook.setOwner("user");

        assertTrue(originalBooks.contains(firstBook));
        assertFalse(library.getAvailableBooks().contains(firstBook));
    }
}
