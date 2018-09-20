package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    private static final String WELCOME = "Welcome!";
    private static final String BOOK_LIST = "Books:";

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
        BibliotecaApp.main(new String[] {});
        assertTrue(outStream.toString().startsWith(WELCOME));
    }

    @Test
    public void listBooksTest() {
        BibliotecaApp.main(new String[] {});
        assertTrue(outStream.toString().startsWith(WELCOME + System.lineSeparator() + BOOK_LIST));
    }
}
