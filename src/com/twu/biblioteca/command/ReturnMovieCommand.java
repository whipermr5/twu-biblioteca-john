package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class ReturnMovieCommand extends MovieCommand {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (getMoviesBorrowedBy(library, "user").isEmpty()) {
            out.println(Ui.NO_MOVIES_CHECKED_OUT);
            return;
        }
        out.println(Ui.formatMoviesCheckedOut(getMoviesBorrowedBy(library, "user")));
        String movieId = Ui.getUserInput(in, out, Ui.SELECT_MOVIE_RETURN);
        if (!isMovie(library.getItem(movieId))) {
            out.println(Ui.RETURN_MOVIE_FAILURE);
            return;
        }
        boolean wasSuccessful = library.returnItem(movieId, "user");
        out.println(wasSuccessful ? Ui.RETURN_MOVIE_SUCCESS : Ui.RETURN_MOVIE_FAILURE);
    }
}
