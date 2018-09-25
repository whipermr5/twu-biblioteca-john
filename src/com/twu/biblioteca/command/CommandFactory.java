package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;

public class CommandFactory {

    public static Command get(String userInput) {
        if (Ui.ID_LOGIN.equals(userInput)) {
            return new LoginCommand();
        }
        if (Ui.ID_LIST_BOOKS.equals(userInput)) {
            return new ListBooksCommand();
        }
        if (Ui.ID_LIST_MOVIES.equals(userInput)) {
            return new ListMoviesCommand();
        }
        if (Ui.ID_CHECKOUT_BOOK.equals(userInput)) {
            return new CheckoutBookCommand();
        }
        if (Ui.ID_CHECKOUT_MOVIE.equals(userInput)) {
            return new CheckoutMovieCommand();
        }
        if (Ui.ID_RETURN_BOOK.equals(userInput)) {
            return new ReturnBookCommand();
        }
        if (Ui.ID_RETURN_MOVIE.equals(userInput)) {
            return new ReturnMovieCommand();
        }
        if (Ui.ID_QUIT.equals(userInput)) {
            return new QuitCommand();
        }
        return new InvalidCommand();
    }
}
