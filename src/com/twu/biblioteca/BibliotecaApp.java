package com.twu.biblioteca;

public class BibliotecaApp {

    private static Library library = new Library();

    public static void main(String[] args) {
        System.out.println(Ui.WELCOME);
        System.out.println(Ui.MENU);
    }

    static Command getUserChoice() {
        String userInput = Ui.getUserInput(System.in);
        return Command.get(userInput);
    }
}
