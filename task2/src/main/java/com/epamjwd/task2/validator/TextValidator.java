package com.epamjwd.task2.validator;

public class TextValidator {
    private static TextValidator instance;
    private static final String REGEX_VALID_TEMPLATE = "^(\\[(-?\\d+\\.(\\d+)?(\\s-?\\d+\\.(\\d+)?){2})\\]\\,\\s){7}(\\[(-?\\d+\\.(\\d+)?(\\s-?\\d+\\.(\\d+)?){2})\\])$";

    public static TextValidator getInstance() {
        if (instance == null) {
            instance = new TextValidator();
        }
        return instance;
    }

    public boolean isTextLineValid(String str) {
        return str != null && str.matches(REGEX_VALID_TEMPLATE);
    }
}
