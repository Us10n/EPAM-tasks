package com.epamjwd.task1.exceptions;

public class FileCloceException extends Exception{
    public FileCloceException() {
        super();
    }

    public FileCloceException(String message) {
        super(message);
    }

    public FileCloceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileCloceException(Throwable cause) {
        super(cause);
    }
}
