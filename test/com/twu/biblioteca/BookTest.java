package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testNewBookTitle() {
        String bookTitle = "Test-driven Development: By Example";
        Book book = new Book(bookTitle);
        assertEquals(bookTitle, book.getTitle());
    }
}
