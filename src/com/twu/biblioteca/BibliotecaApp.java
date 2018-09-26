package com.twu.biblioteca;

import com.twu.biblioteca.command.Command;
import com.twu.biblioteca.command.CommandFactory;
import com.twu.biblioteca.command.QuitCommand;
import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

public class BibliotecaApp {

    private static Library library = new Library();

    public static void main(String[] args) {
        System.out.println(Ui.WELCOME);

        Command command;
        do {
            command = getUserChoice();
            command.execute(library, System.in, System.out);

        } while (!QuitCommand.class.equals(command.getClass()));
    }

    static Command getUserChoice() {
        String menuToDisplay = Ui.getAppropriateMenu(library.getSession());
        String userInput = Ui.getUserInput(System.in, System.out, menuToDisplay);

        return CommandFactory.get(userInput);
    }
}
