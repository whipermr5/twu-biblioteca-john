package com.twu.biblioteca;

abstract class Command {

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
