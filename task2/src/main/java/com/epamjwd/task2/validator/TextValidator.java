package com.epamjwd.task2.validator;

public class TextValidator {
    private static TextValidator instance;
    private static final String REGEX_CUBE_PARAMS = "^\\[(-?\\d+\\.(\\d+)?(\\s-?\\d+\\.(\\d+)?){2})]\\s\\d+\\.(\\d+)?$";

    public static TextValidator getInstance() {
        if (instance == null) {
            instance = new TextValidator();
        }
        return instance;
    }

    public boolean isLineContainParams(String str) {
        return str != null && str.matches(REGEX_CUBE_PARAMS);
    }
}
