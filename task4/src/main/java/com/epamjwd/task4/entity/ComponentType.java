package com.epamjwd.task4.entity;

public enum ComponentType {
    SIGN(""),
    CHARACTER(""),
    EXPRESSION(""),
    WORD(""),
    LEXEME(" "),
    SENTENCE(""),
    PARAGRAPH("\r\n");
    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
