package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Session;
import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class CheckoutBookCommand extends BookCommand {

    public void execute(Library library, InputStream in, PrintStream out) {
        if (getAvailableBooks(library).isEmpty()) {
            out.println(Ui.NO_BOOKS_AVAILABLE);
            return;
        }
        new LoginCommand().execute(library, in, out);
        Session session = library.getSession();
        if (!session.isUserLoggedIn()) {
            return;
        }
        out.println(Ui.formatBooksAvailable(getAvailableBooks(library)));
        String bookId = Ui.getUserInput(in, out, Ui.SELECT_BOOK_CHECKOUT);
        if (!isBook(library.getItem(bookId))) {
            out.println(Ui.CHECKOUT_BOOK_FAILURE);
            return;
        }
        boolean wasSuccessful = library.checkoutItem(bookId, session.getCurrentUser().getUsername());
        out.println(wasSuccessful ? Ui.CHECKOUT_BOOK_SUCCESS : Ui.CHECKOUT_BOOK_FAILURE);
    }
}
