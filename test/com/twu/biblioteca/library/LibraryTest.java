package com.twu.biblioteca.library;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
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
    public void testGetCustomerBooks() {
        assertTrue(library.getCustomerBooks("user").isEmpty());

        firstBook.setOwner("user");
        assertEquals(Collections.singletonList(firstBook), library.getCustomerBooks("user"));

        secondBook.setOwner("user");
        assertEquals(Arrays.asList(firstBook, secondBook), library.getCustomerBooks("user"));

        firstBook.setOwner(null);
        assertEquals(Collections.singletonList(secondBook), library.getCustomerBooks("user"));
    }

    @Test
    public void testCheckout() {
        List<Book> originalBooks = library.getAvailableBooks();
        assertEquals(Arrays.asList(firstBook, secondBook), originalBooks);
        assertTrue(library.checkout(firstBook.getId(), "user"));
        assertEquals(Collections.singletonList(secondBook), library.getAvailableBooks());

        assertTrue(library.checkout(secondBook.getId(), "user"));
        assertTrue(library.getAvailableBooks().isEmpty());

        assertFalse(library.checkout(secondBook.getId(), "user"));
    }

    @Test
    public void testReturnBook() {
        library.checkout(firstBook.getId(), "user");
        library.checkout(secondBook.getId(), "user");
        assertEquals(Arrays.asList(firstBook, secondBook), library.getCustomerBooks("user"));
        assertTrue(library.getAvailableBooks().isEmpty());

        assertTrue(library.returnBook(firstBook.getId(), "user"));
        assertEquals(Collections.singletonList(secondBook), library.getCustomerBooks("user"));
        assertEquals(Collections.singletonList(firstBook), library.getAvailableBooks());

        assertTrue(library.returnBook(secondBook.getId(), "user"));
        assertTrue(library.getCustomerBooks("user").isEmpty());
        assertEquals(Arrays.asList(firstBook, secondBook), library.getAvailableBooks());

        assertFalse(library.returnBook(firstBook.getId(), "user"));
    }
}
