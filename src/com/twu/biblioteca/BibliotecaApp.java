package com.twu.biblioteca;

public class BibliotecaApp {

    private static Library library = new Library();

    public static void main(String[] args) {
        System.out.println(Ui.WELCOME);

        Command command;
        do {
            command = getUserChoice();
            String output = command.execute(library);
            System.out.println(output);

        } while (!QuitCommand.class.equals(command.getClass()));
    }

    static Command getUserChoice() {
        System.out.println();
        System.out.println(Ui.MENU);
        String userInput = Ui.getUserInput(System.in);
        System.out.println();

        return CommandFactory.get(userInput);
    }
}
