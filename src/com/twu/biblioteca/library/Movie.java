package com.twu.biblioteca.library;

public class Movie extends Item {

    private String name;
    private int year;
    private String director;
    private Rating rating;

    public Movie(String name, int year, String director, Rating rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Rating getRating() {
        return rating;
    }
}
