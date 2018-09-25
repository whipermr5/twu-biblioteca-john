package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

public class LoginCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Command command = CommandFactory.get(Ui.ID_LOGIN);

        String credentials = "invalid username" + System.lineSeparator() + "some password";
        InputStream in = new ByteArrayInputStream(credentials.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        String expected = Ui.LOGIN_PROMPT_USERNAME + Ui.LOGIN_PROMPT_PASSWORD + System.lineSeparator()
                + Ui.LOGIN_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        credentials = "valid username" + System.lineSeparator() + "valid password";
        in = new ByteArrayInputStream(credentials.getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.LOGIN_PROMPT_USERNAME + Ui.LOGIN_PROMPT_PASSWORD + System.lineSeparator()
                + String.format(Ui.LOGIN_SUCCESS_FORMAT, "valid username") + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        expected = String.format(Ui.LOGIN_SUCCESS_FORMAT, "valid username") + System.lineSeparator();
        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(expected, out.toString());
    }
}
