package com.twu.biblioteca.common;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.Movie;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {

    public static final String ID_LOGIN = "li";
    public static final String ID_LOGOUT = "lo";
    public static final String ID_USER_INFO = "ui";
    public static final String ID_LIST_BOOKS = "lb";
    public static final String ID_LIST_RECORDS = "lr";
    public static final String ID_LIST_MOVIES = "lm";
    public static final String ID_CHECKOUT_BOOK = "cb";
    public static final String ID_CHECKOUT_MOVIE = "cm";
    public static final String ID_RETURN_BOOK = "rb";
    public static final String ID_RETURN_MOVIE = "rm";
    public static final String ID_QUIT = "q";

    public static final String WELCOME = "Welcome!";
    public static final String MENU = System.lineSeparator() + "------ MENU -------" + System.lineSeparator()
            + ID_LOGIN + " - Login" + System.lineSeparator()
            + ID_LIST_BOOKS + " - List Books" + System.lineSeparator()
            + ID_LIST_MOVIES + " - List Movies" + System.lineSeparator()
            + ID_CHECKOUT_BOOK + " - Checkout Book" + System.lineSeparator()
            + ID_CHECKOUT_MOVIE + " - Checkout Movie" + System.lineSeparator()
            + ID_RETURN_BOOK + " - Return Book" + System.lineSeparator()
            + ID_RETURN_MOVIE + " - Return Movie" + System.lineSeparator()
            + ID_QUIT + " - Quit" + System.lineSeparator()
            + "Please select an option: ";
    public static final String INVALID_OPTION = "Select a valid option!";
    public static final String LOGIN_PROMPT_USERNAME = "Library number: ";
    public static final String LOGIN_PROMPT_PASSWORD = "Password: ";
    public static final String LOGIN_SUCCESS_FORMAT = "Logged into account %s.";
    public static final String LOGIN_FAILURE = "Access denied.";
    public static final String LOGOUT_SUCCESS = "Logged out successfully.";
    public static final String LOGOUT_FAILURE = "You are not logged in.";
    public static final String SELECT_BOOK_CHECKOUT = "Enter ID of book to checkout: ";
    public static final String SELECT_BOOK_RETURN = "Enter ID of book to return: ";
    public static final String SELECT_MOVIE_CHECKOUT = "Enter ID of movie to checkout: ";
    public static final String SELECT_MOVIE_RETURN = "Enter ID of movie to return: ";
    public static final String NO_BOOKS_AVAILABLE = "No books available!";
    public static final String NO_BOOKS_CHECKED_OUT = "You have not checked out any books.";
    public static final String NO_RECORDS = "No customer has checked out any books.";
    public static final String NO_MOVIES_AVAILABLE = "No movies available!";
    public static final String NO_MOVIES_CHECKED_OUT = "You have not checked out any movies.";
    public static final String CHECKOUT_BOOK_SUCCESS = "Thank you! Enjoy the book";
    public static final String CHECKOUT_BOOK_FAILURE = "That book is not available.";
    public static final String CHECKOUT_MOVIE_SUCCESS = "Thank you! Enjoy the movie";
    public static final String CHECKOUT_MOVIE_FAILURE = "That movie is not available.";
    public static final String RETURN_BOOK_SUCCESS = "Thank you for returning the book.";
    public static final String RETURN_BOOK_FAILURE = "That is not a valid book to return.";
    public static final String RETURN_MOVIE_SUCCESS = "Thank you for returning the movie.";
    public static final String RETURN_MOVIE_FAILURE = "That is not a valid movie to return.";
    public static final String GOODBYE = "Goodbye!";

    static final String BOOKS_AVAILABLE =
            "---------------------- Books Available for Checkout -----------------------";
    static final String BOOKS_CHECKED_OUT =
            "------------------------ Books You've Checked Out -------------------------";
    static final String BOOK_DETAILS_FORMAT_STRING = "%n%-2s | %-40s | %-20s | %4s";
    static final String BOOK_LIST_HEADER =
            String.format(Ui.BOOK_DETAILS_FORMAT_STRING, "ID", "Title", "Author", "Year") + System.lineSeparator()
            + "---------------------------------------------------------------------------";

    static final String RECORDS =
            "-------------------------- Books Customers Have Checked Out --------------------------";
    static final String RECORD_DETAILS_FORMAT_STRING = "%n%-2s | %-40s | %-20s | %-4s | %8s";
    static final String RECORD_LIST_HEADER =
            String.format(Ui.RECORD_DETAILS_FORMAT_STRING, "ID", "Title", "Author", "Year", "Customer")
            + System.lineSeparator()
            + "--------------------------------------------------------------------------------------";

    static final String MOVIES_AVAILABLE =
            "----------------------------- Movies Available for Checkout -----------------------------";
    static final String MOVIES_CHECKED_OUT =
            "------------------------------- Movies You've Checked Out -------------------------------";
    static final String MOVIE_DETAILS_FORMAT_STRING = "%n%-2s | %-40s | %-4s | %-20s | %5s";
    static final String MOVIE_LIST_HEADER =
            String.format(Ui.MOVIE_DETAILS_FORMAT_STRING, "ID", "Name", "Year", "Director", "Rating")
            + System.lineSeparator()
            + "-----------------------------------------------------------------------------------------";

    static final String USER_INFO_FORMAT_STRING = "------- Your Info -------" + System.lineSeparator()
            + "Library number: %s%nName: %s%nEmail: %s%nNumber: %s" + System.lineSeparator()
            + "-------------------------";

    public static final String RATING_SYMBOL = "*";
    public static final String UNRATED = "Unrated";

    public static String getUserInput(InputStream in, PrintStream out, String messageToUser) {
        return getUserInputs(in, out, messageToUser)[0];
    }

    public static String[] getUserInputs(InputStream in, PrintStream out, String... messagesToUser) {
        Scanner scanner = new Scanner(in);
        ArrayList<String> userInputs = new ArrayList<>();
        for (String messageToUser : messagesToUser) {
            out.print(messageToUser);
            userInputs.add(scanner.nextLine());
        }
        out.println();
        return userInputs.toArray(new String[0]);
    }

    private static String formatBooks(List<Book> books, String title, String emptyMessage) {
        if (books == null) {
            return null;
        }

        if (books.isEmpty()) {
            return emptyMessage;
        }

        StringBuilder sb = new StringBuilder(title);
        sb.append(BOOK_LIST_HEADER);
        for (Book book : books) {
            sb.append(String.format(BOOK_DETAILS_FORMAT_STRING,
                    book.getId(), book.getTitle(), book.getAuthor(), book.getYear()));
        }
        return sb.toString();
    }

    public static String formatBooksAvailable(List<Book> books) {
        return formatBooks(books, BOOKS_AVAILABLE, NO_BOOKS_AVAILABLE);
    }

    public static String formatBooksCheckedOut(List<Book> books) {
        return formatBooks(books, BOOKS_CHECKED_OUT, NO_BOOKS_CHECKED_OUT);
    }

    public static String formatBookRecords(List<Book> books, Library library) {
        if (books == null) {
            return null;
        }

        if (books.isEmpty()) {
            return NO_RECORDS;
        }

        StringBuilder sb = new StringBuilder(RECORDS);
        sb.append(RECORD_LIST_HEADER);
        for (Book book : books) {
            sb.append(String.format(RECORD_DETAILS_FORMAT_STRING,
                    book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), library.getBorrower(book)));
        }
        return sb.toString();
    }

    private static String formatMovies(List<Movie> movies, String title, String emptyMessage) {
        if (movies == null) {
            return null;
        }

        if (movies.isEmpty()) {
            return emptyMessage;
        }

        StringBuilder sb = new StringBuilder(title);
        sb.append(MOVIE_LIST_HEADER);
        for (Movie movie : movies) {
            sb.append(String.format(MOVIE_DETAILS_FORMAT_STRING,
                    movie.getId(), movie.getName(),movie.getYear(), movie.getDirector(), movie.getRating()));
        }
        return sb.toString();
    }

    public static String formatMoviesAvailable(List<Movie> movies) {
        return formatMovies(movies, MOVIES_AVAILABLE, NO_MOVIES_AVAILABLE);
    }

    public static String formatMoviesCheckedOut(List<Movie> movies) {
        return formatMovies(movies, MOVIES_CHECKED_OUT, NO_MOVIES_CHECKED_OUT);
    }

    public static String formatUserInfo(User user) {
        if (user == null) {
            return null;
        }

        return String.format(USER_INFO_FORMAT_STRING,
                user.getUsername(), user.getName(), user.getEmail(), user.getNumber());
    }
}
