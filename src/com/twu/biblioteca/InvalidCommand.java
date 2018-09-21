package com.twu.biblioteca;

class InvalidCommand extends Command {

    String execute(Library library) {
        return Ui.INVALID_OPTION;
    }
}
