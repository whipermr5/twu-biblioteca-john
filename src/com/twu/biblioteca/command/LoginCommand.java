package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Session;
import com.twu.biblioteca.common.Ui;
import com.twu.biblioteca.library.Library;

import java.io.InputStream;
import java.io.PrintStream;

public class LoginCommand extends Command {

    public void execute(Library library, InputStream in, PrintStream out) {
        Session session = library.getSession();
        if (session.isUserLoggedIn()) {
            return;
        }
        String[] inputs = Ui.getUserInputs(in, out, Ui.LOGIN_PROMPT_USERNAME, Ui.LOGIN_PROMPT_PASSWORD);
        String username = inputs[0];
        String password = inputs[1];
        boolean wasSuccessful = session.login(username, password);
        out.println(wasSuccessful ? String.format(Ui.LOGIN_SUCCESS_FORMAT, username) : Ui.LOGIN_FAILURE);
    }
}
