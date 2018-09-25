package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Session;
import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListRecordsCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Session session = library.getSession();
        Command command = new ListRecordsCommand();

        assertFalse(session.isAdminLoggedIn());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.INVALID_OPTION + System.lineSeparator(), out.toString());

        session.login("librarian", "librarian password");
        assertTrue(session.isAdminLoggedIn());
        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.NO_RECORDS + System.lineSeparator(), out.toString());

        Book firstItem = (Book) library.getAvailableItems().iterator().next();
        library.checkoutItem(firstItem.getId(), "user abc");
        out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        String expected = Ui.formatBookRecords(BookCommand.getUnavailableBooks(library), library)
                + System.lineSeparator();
        assertEquals(expected, out.toString());
    }
}
