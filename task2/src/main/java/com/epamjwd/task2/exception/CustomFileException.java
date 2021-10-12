package com.epamjwd.task2.exception;

public class CustomFileException extends Exception{
    public CustomFileException() {
        super();
    }

    public CustomFileException(String message) {
        super(message);
    }

    public CustomFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomFileException(Throwable cause) {
        super(cause);
    }
}
