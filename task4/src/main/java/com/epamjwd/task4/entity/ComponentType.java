package com.epamjwd.task4.entity;

public enum ComponentType {
    SYMBOL(""),
    LETTER(""),
    MARK(""),
    WORD(""),
    LEXEME(" "),
    SENTENCE(""),
    PARAGRAPH("\n\t");
    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
