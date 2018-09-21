package com.twu.biblioteca.common;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Ui {

    public static final String ID_LIST_BOOKS = "l";
    public static final String ID_CHECKOUT = "c";
    public static final String ID_QUIT = "q";

    public static final String WELCOME = "Welcome!";
    public static final String MENU = "------ MENU ------" + System.lineSeparator()
            + ID_LIST_BOOKS + " - List Books" + System.lineSeparator()
            + ID_CHECKOUT + " - Checkout Book" + System.lineSeparator()
            + ID_QUIT + " - Quit" + System.lineSeparator()
            + "Please select an option: ";
    public static final String INVALID_OPTION = "Select a valid option!";
    public static final String CHECKOUT_SUCCESS = "Thank you! Enjoy the book";
    public static final String CHECKOUT_FAILURE = "That book is not available.";
    public static final String GOODBYE = "Goodbye!";

    static final String NO_BOOKS = "No books!";
    static final String BOOK_DETAILS_FORMAT_STRING = "%n%-2s | %-40s | %-20s | %4s";
    static final String BOOK_LIST_HEADER = "Books:"
            + String.format(Ui.BOOK_DETAILS_FORMAT_STRING, "ID", "Title", "Author", "Year") + System.lineSeparator()
            + "---------------------------------------------------------------------------";

    public static String getUserInput(InputStream in, OutputStream out, String messageToUser) {
        PrintStream outStream = new PrintStream(out);
        outStream.print(messageToUser);
        Scanner scanner = new Scanner(in);
        String userInput = scanner.nextLine();
        outStream.println();
        return userInput;
    }

    public static String formatBookList(List<Book> books) {
        if (books == null) {
            return null;
        }

        if (books.isEmpty()) {
            return NO_BOOKS;
        }

        StringBuilder sb = new StringBuilder(BOOK_LIST_HEADER);
        for (Book book : books) {
            sb.append(String.format(BOOK_DETAILS_FORMAT_STRING,
                    book.getId(), book.getTitle(), book.getAuthor(), book.getYear()));
        }
        return sb.toString();
    }
}
