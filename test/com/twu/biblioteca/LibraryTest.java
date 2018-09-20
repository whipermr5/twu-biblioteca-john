package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private static final String BOOK1_TITLE = "TDD";
    private static final String BOOK1_AUTHOR = "Kent";
    private static final int BOOK1_YEAR = 2002;

    private static final String BOOK2_TITLE = "Refactoring";
    private static final String BOOK2_AUTHOR = "Martin";
    private static final int BOOK2_YEAR = 1999;

    private static final List BOOK_LIST = Arrays.asList(
            new Book(BOOK1_TITLE, BOOK1_AUTHOR, BOOK1_YEAR), new Book(BOOK2_TITLE, BOOK2_AUTHOR, BOOK2_YEAR));

    @Test
    public void testGetBooks() {
        assertEquals(BOOK_LIST, new Library().getBooks());
    }
}
