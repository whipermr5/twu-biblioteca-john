package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;
import com.twu.biblioteca.common.Ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class CheckoutCommand extends Command {

    public void execute(Library library, InputStream in, OutputStream out) {
        String bookId = Ui.getUserInput(in, out, "");
        boolean wasSuccessful = library.checkout(bookId, "user");
        if (wasSuccessful) {
            new PrintStream(out).println(Ui.CHECKOUT_SUCCESS);
        } else {
            new PrintStream(out).println(Ui.CHECKOUT_FAILURE);
        }
    }
}
