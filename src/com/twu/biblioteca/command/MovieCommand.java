package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;

import java.util.List;
import java.util.stream.Collectors;

abstract class MovieCommand extends Command {

    static List<Movie> getAvailableMovies(Library library) {
        return library.getAvailableItems().stream().filter(item -> item instanceof Movie).map(Movie.class::cast)
                .collect(Collectors.toList());
    }

    static List<Movie> getMoviesBorrowedBy(Library library, String borrowerId) {
        return library.getItemsBorrowedBy(borrowerId).stream()
                .filter(item -> item instanceof Movie).map(Movie.class::cast)
                .collect(Collectors.toList());
    }

    static boolean isMovie(Item item) {
        return item instanceof Movie;
    }
}
