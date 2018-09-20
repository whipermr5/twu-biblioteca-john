package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void testNewBookTitle() {
        String bookTitle = "Test-driven Development: By Example";
        Book book = new Book(bookTitle);
        assertEquals(bookTitle, book.getTitle());
    }

    @Test
    public void testEquality() {
        String bookTitle1 = "TDD";
        String bookTitle2 = "Refactoring";
        assertEquals(new Book(bookTitle1), new Book(bookTitle1));
        assertNotEquals(new Book(bookTitle1), new Book(bookTitle2));
        assertNotEquals(new Book(bookTitle1), null);
        assertNotEquals(new Book(bookTitle1), "string");
    }
}
