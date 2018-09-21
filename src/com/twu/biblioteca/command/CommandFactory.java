package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;

public class CommandFactory {

    public static Command get(String userInput) {
        if (Ui.ID_LIST_BOOKS.equals(userInput)) {
            return new ListBooksCommand();
        }
        if (Ui.ID_QUIT.equals(userInput)) {
            return new QuitCommand();
        }
        return new InvalidCommand();
    }
}
