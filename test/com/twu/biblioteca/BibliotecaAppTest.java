package com.twu.biblioteca;


import org.hamcrest.core.StringStartsWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    private String getOutput() {
        return outStream.toString();
    }

    private void assertOutputStartsWith(String expected) {
        assertThat(getOutput(), StringStartsWith.startsWith(expected));
    }
}
