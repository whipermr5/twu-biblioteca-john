package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

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
    }

    @Test
    public void testEquality() {
        Book book1 = new Book("Title", "Author", 2018);
        Book book2 = new Book("Title", "Author", 2018);

        assertEquals(book1, book1);
        assertNotEquals(book1, book2);
    }
}
