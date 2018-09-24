package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MovieCommandTest {

    private static Library library;
    private static Movie thirdItem;

    @Before
    public void setUp() {
        library = new Library();
        thirdItem = (Movie) library.getAvailableItems().get(2);
        library.checkoutItem(thirdItem.getId(), "user");
    }

    @Test
    public void testGetAvailableMovies() {
        assertFalse(MovieCommand.getAvailableMovies(library).contains(thirdItem));
        List<Movie> expected = library.getAvailableItems().stream()
                .filter(item -> item instanceof Movie).map(Movie.class::cast).collect(Collectors.toList());
        assertEquals(expected, MovieCommand.getAvailableMovies(library));
    }

    @Test
    public void testGetMoviesBorrowedBy() {
        assertEquals(Collections.singletonList(thirdItem), MovieCommand.getMoviesBorrowedBy(library, "user"));
    }
}
