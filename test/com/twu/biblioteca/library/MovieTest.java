package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testConstructor() {
        String name = "The Day After Tomorrow";
        int year = 2004;
        String director = "Roland Emmerich";
        Rating rating = Rating.of(7);

        Movie movie = new Movie(name, year, director, rating);
        assertEquals(name, movie.getName());
        assertEquals(year, movie.getYear());
        assertEquals(director, movie.getDirector());
        assertEquals(rating, movie.getRating());
    }
}
