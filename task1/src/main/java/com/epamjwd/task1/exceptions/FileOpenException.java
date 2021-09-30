package com.epamjwd.task1.exceptions;

public class FileOpenException extends Exception{
    public FileOpenException() {
        super();
    }

    public FileOpenException(String message) {
        super(message);
    }

    public FileOpenException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileOpenException(Throwable cause) {
        super(cause);
    }
}
