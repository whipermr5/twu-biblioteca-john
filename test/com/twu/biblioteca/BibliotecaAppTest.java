package com.twu.biblioteca;


import org.hamcrest.core.StringStartsWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private static final String OUTPUT_WELCOME = "Welcome!";
    private static final String OUTPUT_MENU = "Please select an option:" + System.lineSeparator() + "1. List Books";

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
    public void welcomeOutputTest() {
        BibliotecaApp.main(new String[] {});
        assertOutputStartsWith(OUTPUT_WELCOME);
    }

    @Test
    public void menuOutputTest() {
        BibliotecaApp.main(new String[] {});
        assertOutputStartsWith(OUTPUT_WELCOME + System.lineSeparator() + OUTPUT_MENU);
    }

    @Test
    public void testGetUserChoice() {
        InputStream stdinStream = System.in;

        ByteArrayInputStream inStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inStream);
        assertEquals(ListBooksCommand.class, BibliotecaApp.getUserChoice().getClass());

        inStream = new ByteArrayInputStream("q".getBytes());
        System.setIn(inStream);
        assertEquals(QuitCommand.class, BibliotecaApp.getUserChoice().getClass());

        System.setIn(stdinStream);
    }

    private String getOutput() {
        return outStream.toString();
    }

    private void assertOutputStartsWith(String expected) {
        assertThat(getOutput(), StringStartsWith.startsWith(expected));
    }
}
