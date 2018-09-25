package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReturnMovieCommandTest {

    @Test
    public void testExecute() {
        Library library = new Library();
        Command command = CommandFactory.get(Ui.ID_RETURN_MOVIE);

        Movie firstMovie = MovieCommand.getAvailableMovies(library).get(0);
        Movie secondMovie = MovieCommand.getAvailableMovies(library).get(1);
        OutputStream out = new ByteArrayOutputStream();
        command.execute(library, null, out);
        assertEquals(Ui.NO_MOVIES_CHECKED_OUT + System.lineSeparator(), out.toString());

        library.checkoutItem(firstMovie.getId(), "user");
        assertEquals(Collections.singletonList(firstMovie), MovieCommand.getMoviesBorrowedBy(library, "user"));
        InputStream in = new ByteArrayInputStream(secondMovie.getId().getBytes());
        out = new ByteArrayOutputStream();
        String expected = Ui.formatMoviesCheckedOut(
                MovieCommand.getMoviesBorrowedBy(library, "user")) + System.lineSeparator()
                + Ui.SELECT_MOVIE_RETURN + System.lineSeparator()
                + Ui.RETURN_MOVIE_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        Book book = BookCommand.getAvailableBooks(library).iterator().next();
        library.checkoutItem(book.getId(), "user");
        in = new ByteArrayInputStream(book.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatMoviesCheckedOut(
                MovieCommand.getMoviesBorrowedBy(library, "user")) + System.lineSeparator()
                + Ui.SELECT_MOVIE_RETURN + System.lineSeparator()
                + Ui.RETURN_MOVIE_FAILURE + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());

        in = new ByteArrayInputStream(firstMovie.getId().getBytes());
        out = new ByteArrayOutputStream();
        expected = Ui.formatMoviesCheckedOut(
                MovieCommand.getMoviesBorrowedBy(library, "user")) + System.lineSeparator()
                + Ui.SELECT_MOVIE_RETURN + System.lineSeparator()
                + Ui.RETURN_MOVIE_SUCCESS + System.lineSeparator();
        command.execute(library, in, out);
        assertEquals(expected, out.toString());
        assertFalse(BookCommand.getBooksBorrowedBy(library, "user").contains(firstMovie));
    }
}
