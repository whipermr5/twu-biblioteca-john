package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class ListMoviesCommandTest {

    @Test
    public void testExecute() {
        Command command = CommandFactory.get(Ui.ID_LIST_MOVIES);
        Library library = new Library();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        String expected = Ui.formatMoviesAvailable(MovieCommand.getAvailableMovies(library)) + System.lineSeparator();
        assertEquals(expected, out.toString());
    }
}
