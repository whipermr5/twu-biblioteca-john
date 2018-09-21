package com.twu.biblioteca.command;

import com.twu.biblioteca.common.Library;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class Command {

    public abstract String execute(Library library, InputStream in, OutputStream out);
}
