package com.twu.biblioteca;

class QuitCommand extends Command {

    String execute(Library library) {
        return Ui.GOODBYE;
    }
}
