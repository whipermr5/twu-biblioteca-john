package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Session;
import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserInfoCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Session session = library.getSession();
        Command command = new UserInfoCommand();

        assertFalse(session.isUserLoggedIn());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.INVALID_OPTION + System.lineSeparator(), out.toString());

        session.login("000-0000", "0");
        assertTrue(session.isUserLoggedIn());
        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.formatUserInfo(session.getCurrentUser()) + System.lineSeparator(), out.toString());
    }
}
