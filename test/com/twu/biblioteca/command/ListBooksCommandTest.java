package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class ListBooksCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get(Ui.ID_LIST_BOOKS);
        Library library = new Library();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        command.execute(library, null, out);

        assertEquals(Ui.formatBooksAvailable(
                BookCommand.getAvailableBooks(library)) + System.lineSeparator(), out.toString());
    }
}
