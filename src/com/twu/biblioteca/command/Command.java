package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;

import java.io.InputStream;

public abstract class Command {

    public abstract String execute(Library library, InputStream in);
}
