package com.twu.biblioteca;

public class CommandFactory {

    static Command get(String userInput) {
        if ("1".equals(userInput)) {
            return new ListBooksCommand();
        }
        if ("q".equals(userInput)) {
            return new QuitCommand();
        }
        return new InvalidCommand();
    }
}
