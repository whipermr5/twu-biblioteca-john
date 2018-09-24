package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.Ui;

import java.io.InputStream;
import java.io.PrintStream;

public class CheckoutBookCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (library.getAvailableBooks().isEmpty()) {
            out.println(Ui.NO_BOOKS_AVAILABLE);
            return;
        }
        out.println(Ui.formatBooksAvailable(library.getAvailableBooks()));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK_CHECKOUT);
        boolean wasSuccessful = library.checkoutItem(bookId, "user");
        out.println(wasSuccessful ? Ui.CHECKOUT_SUCCESS : Ui.CHECKOUT_FAILURE);
    }
}
