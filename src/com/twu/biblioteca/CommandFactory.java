package com.twu.biblioteca;

public class CommandFactory {

    static Command get(String userInput) {
        if (Ui.ID_LIST_BOOKS.equals(userInput)) {
            return new ListBooksCommand();
        }
        if (Ui.ID_QUIT.equals(userInput)) {
            return new QuitCommand();
        }
        return new InvalidCommand();
    }
}
