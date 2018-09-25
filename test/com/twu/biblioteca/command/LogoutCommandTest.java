package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoutCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Command command = CommandFactory.get(Ui.ID_LOGOUT);

        OutputStream out = new ByteArrayOutputStream();
        String expected = Ui.LOGOUT_FAILURE + System.lineSeparator();
        command.execute(library, null, out);
        assertEquals(expected, out.toString());

        assertTrue(library.getSession().login("valid username", "valid password"));
        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        expected = Ui.LOGOUT_SUCCESS + System.lineSeparator();
        assertEquals(expected, out.toString());
    }
}
