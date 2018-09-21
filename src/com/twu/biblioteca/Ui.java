package com.twu.biblioteca;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

class Ui {

    static final String ID_LIST_BOOKS = "l";
    static final String ID_QUIT = "q";

    static final String BOOK_DETAILS_FORMAT_STRING = "%n%-40s | %-20s | %4s";
    static final String BOOK_LIST_HEADER = "Books:"
            + String.format(Ui.BOOK_DETAILS_FORMAT_STRING, "Title", "Author", "Year") + System.lineSeparator()
            + "----------------------------------------------------------------------";

    static final String WELCOME = "Welcome!";
    static final String MENU = "Please select an option:" + System.lineSeparator()
            + ID_LIST_BOOKS + " - List Books" + System.lineSeparator()
            + ID_QUIT + " - Quit";
    static final String INVALID_OPTION = "Select a valid option!";
    static final String NO_BOOKS = "No books!";
    static final String GOODBYE = "Goodbye!";

    static String getUserInput(InputStream in) {
        Scanner scanner = new Scanner(in);
        return scanner.nextLine();
    }

    static String formatBookList(List<Book> books) {
        if (books == null) {
            return null;
        }

        if (books.isEmpty()) {
            return NO_BOOKS;
        }

        StringBuilder sb = new StringBuilder(BOOK_LIST_HEADER);
        for (Book book : books) {
            sb.append(String.format(BOOK_DETAILS_FORMAT_STRING, book.getTitle(), book.getAuthor(), book.getYear()));
        }
        return sb.toString();
    }
}
