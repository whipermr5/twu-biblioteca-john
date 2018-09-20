package com.twu.biblioteca;


import org.hamcrest.core.StringStartsWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private static final String EOL = System.lineSeparator();

    private static final String BOOK1_TITLE = "TDD";
    private static final String BOOK2_TITLE = "Refactoring";

    private static final List BOOK_LIST = Arrays.asList(new Book(BOOK1_TITLE), new Book(BOOK2_TITLE));

    private static final String OUTPUT_WELCOME = "Welcome!";
    private static final String OUTPUT_BOOK_LIST_HEADER = "Books:";
    private static final String OUTPUT_BOOK_LIST = OUTPUT_BOOK_LIST_HEADER + EOL + BOOK1_TITLE + EOL + BOOK2_TITLE;

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private PrintStream stdoutStream = System.out;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outStream));
    }

    @After
    public void restoreStream() {
        System.setOut(stdoutStream);
    }

    @Test
    public void welcomeTest() {
        assertEquals(OUTPUT_WELCOME, BibliotecaApp.welcome());
    }

    @Test
    public void welcomeOutputTest() {
        BibliotecaApp.main(new String[] {});
        assertOutputStartsWith(OUTPUT_WELCOME);
    }

    @Test
    public void listBooksTest() {
        assertEquals(BOOK_LIST, BibliotecaApp.listBooks());
    }

    @Test
    public void formatBookListTest() {
        assertNull(BibliotecaApp.formatBookList(null));

        assertEquals(OUTPUT_BOOK_LIST_HEADER, BibliotecaApp.formatBookList(Collections.emptyList()));

        String title1 = "Book one";
        assertEquals(OUTPUT_BOOK_LIST_HEADER + EOL + title1,
                BibliotecaApp.formatBookList(Collections.singletonList(new Book(title1))));

        String title2 = "Book two";
        assertEquals(OUTPUT_BOOK_LIST_HEADER + EOL + title1 + EOL + title2,
                BibliotecaApp.formatBookList(Arrays.asList(new Book(title1), new Book(title2))));
    }

    @Test
    public void formatBookListOutputTest() {
        BibliotecaApp.main(new String[] {});
        assertOutputStartsWith(OUTPUT_WELCOME + EOL + OUTPUT_BOOK_LIST);
    }

    private String getOutput() {
        return outStream.toString();
    }

    private void assertOutputStartsWith(String expected) {
        assertThat(getOutput(), StringStartsWith.startsWith(expected));
    }
}
