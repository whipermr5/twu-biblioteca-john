package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class ListMoviesCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        out.println(Ui.formatMoviesAvailable(library.getAvailableMovies()));
    }
}
