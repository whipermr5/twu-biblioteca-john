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
        String title1 = "TDD";
        String title2 = "Refactoring";
        String author1 = "Kent";
        String author2 = "Martin";
        int year1 = 2002;
        int year2 = 1999;

        assertEquals(new Book(title1, author1, year1), new Book(title1, author1, year1));

        assertNotEquals(new Book(title1, author1, year1), new Book(title2, author1, year1));
        assertNotEquals(new Book(title1, author1, year1), new Book(title1, author2, year1));
        assertNotEquals(new Book(title1, author1, year1), new Book(title1, author1, year2));

        assertNotEquals(new Book(title1, author1, year1), null);
        assertNotEquals(new Book(title1, author1, year1), "string");
    }
}
