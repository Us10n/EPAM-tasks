package com.epamjwd.task1.exceptions;

public class WrongDataFileException extends Exception{
    public WrongDataFileException(String message) {
        super(message);
    }

    public WrongDataFileException() {
        super();
    }

    public WrongDataFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataFileException(Throwable cause) {
        super(cause);
    }
}
