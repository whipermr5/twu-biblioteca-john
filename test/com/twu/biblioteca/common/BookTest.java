package com.twu.biblioteca.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testId() {
        Book book1 = new Book(null, null, 0);
        int book1NumericalId = Integer.parseInt(book1.getId());

        Book book2 = new Book(null, null, 0);
        assertEquals(String.valueOf(book1NumericalId + 1), book2.getId());

        assertEquals(String.valueOf(book1NumericalId), book1.getId());
    }

    @Test
    public void testConstructor() {
        String title = "Test-driven Development: By Example";
        String author = "Kent Beck";
        int year = 2002;
        Book book = new Book(title, author, year);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(year, book.getYear());
        assertNull(book.getOwner());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testOwnership() {
        Book book = new Book("Title", "Author", 2018);
        String user = "user";

        book.setOwner(user);
        assertEquals(user, book.getOwner());
        assertFalse(book.isAvailable());

        book.setOwner(null);
        assertNull(book.getOwner());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testEquality() {
        Book book1 = new Book("Title", "Author", 2018);
        Book book2 = new Book("Title", "Author", 2018);

        assertEquals(book1, book1);
        assertNotEquals(book1, book2);
    }
}
