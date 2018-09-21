package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.OutputStream;

public class CheckoutCommand extends Command {

    public String execute(Library library, InputStream in, OutputStream out) {
        String bookId = Ui.getUserInput(in, out, "");
        boolean wasSuccessful = library.checkout(bookId, "user");
        return wasSuccessful ? Ui.CHECKOUT_SUCCESS : Ui.CHECKOUT_FAILURE;
    }
}
