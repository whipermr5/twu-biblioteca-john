package com.twu.biblioteca;


import com.twu.biblioteca.command.ListBooksCommand;
import com.twu.biblioteca.command.QuitCommand;
import com.twu.biblioteca.common.Ui;
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

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private PrintStream stdoutStream = System.out;
    private InputStream stdinStream = System.in;

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outStream));
        System.setIn(new ByteArrayInputStream(Ui.ID_QUIT.getBytes()));
    }

    @After
    public void restoreStream() {
        System.setOut(stdoutStream);
        System.setIn(stdinStream);
    }

    @Test
    public void testWelcome() {
        BibliotecaApp.main(new String[] {});
        assertOutputStartsWith(Ui.WELCOME);
    }

    @Test
    public void testGetUserChoice() {
        BibliotecaApp.getUserChoice();
        String expected = System.lineSeparator() + Ui.MENU + System.lineSeparator();
        assertEquals(expected, getOutput());

        System.setIn(getInputStream(Ui.ID_LIST_BOOKS));
        assertEquals(ListBooksCommand.class, BibliotecaApp.getUserChoice().getClass());

        System.setIn(getInputStream(Ui.ID_QUIT));
        assertEquals(QuitCommand.class, BibliotecaApp.getUserChoice().getClass());
    }

    private String getOutput() {
        return outStream.toString();
    }

    private static InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private void assertOutputStartsWith(String expected) {
        assertThat(getOutput(), StringStartsWith.startsWith(expected));
    }
}
