package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class CheckoutMovieCommand extends MovieCommand {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (getAvailableMovies(library).isEmpty()) {
            out.println(Ui.NO_MOVIES_AVAILABLE);
            return;
        }
        new ListMoviesCommand().execute(library, in, out);
        String movieId = Ui.getUserInput(in, out, Ui.SELECT_MOVIE_CHECKOUT);
        if (!isMovie(library.getItem(movieId))) {
            out.println(Ui.CHECKOUT_MOVIE_FAILURE);
            return;
        }
        boolean wasSuccessful = library.checkoutItem(movieId, "user");
        out.println(wasSuccessful ? Ui.CHECKOUT_MOVIE_SUCCESS : Ui.CHECKOUT_MOVIE_FAILURE);
    }
}
