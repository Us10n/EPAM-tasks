package com.epamjwd.lab0.validator;

public class CustomValidator {
    private static CustomValidator instance;
    private static final String REGEX_VALID_TEMPLATE = "^-?\\d+\\.(\\d+)?(\\s-?\\d+\\.(\\d+)?)*$";

    public static CustomValidator getInstance() {
        if (instance == null) {
            instance = new CustomValidator();
        }
        return instance;
    }

    public boolean isTextLineValid(String str) {
        return str.matches(REGEX_VALID_TEMPLATE);
    }
}
