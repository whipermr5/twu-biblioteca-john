package com.twu.biblioteca.common;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Ui {

    public static final String ID_LIST_BOOKS = "l";
    public static final String ID_QUIT = "q";

    public static final String WELCOME = "Welcome!";
    public static final String MENU = "Please select an option:" + System.lineSeparator()
            + ID_LIST_BOOKS + " - List Books" + System.lineSeparator()
            + ID_QUIT + " - Quit";
    public static final String INVALID_OPTION = "Select a valid option!";
    public static final String GOODBYE = "Goodbye!";

    static final String NO_BOOKS = "No books!";
    static final String BOOK_DETAILS_FORMAT_STRING = "%n%-2s | %-40s | %-20s | %4s";
    static final String BOOK_LIST_HEADER = "Books:"
            + String.format(Ui.BOOK_DETAILS_FORMAT_STRING, "ID", "Title", "Author", "Year") + System.lineSeparator()
            + "---------------------------------------------------------------------------";

    public static String getUserInput(InputStream in) {
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
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