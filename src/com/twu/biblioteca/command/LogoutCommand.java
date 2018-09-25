package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class LogoutCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        boolean wasSuccessful = library.getSession().logout();
        out.println(wasSuccessful ? Ui.LOGOUT_SUCCESS : Ui.LOGOUT_FAILURE);
    }
}
