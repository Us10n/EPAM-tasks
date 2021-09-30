package com.epamjwd.task1.exceptions;


public class IllegalArrayType extends Exception{
    public IllegalArrayType() {
        super();
    }

    public IllegalArrayType(String message) {
        super(message);
    }

    public IllegalArrayType(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalArrayType(Throwable cause) {
        super(cause);
    }
}
