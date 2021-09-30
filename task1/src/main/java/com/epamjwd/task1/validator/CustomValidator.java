package com.epamjwd.task1.validator;

import com.epamjwd.task1.exceptions.IllegalArrayType;
import com.epamjwd.task1.factory.ArrayType;
import com.epamjwd.task1.parser.CustomParser;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

public class CustomValidator {
    private static CustomValidator instance;

    public static CustomValidator getInstance() {
        if (instance == null) {
            instance = new CustomValidator();
        }
        return instance;
    }

    public boolean isTextLineValid(String str, ArrayType type) throws IllegalArrayType {
        switch (type) {
            case DoubleArray: {
                str = str.replaceAll(", +"," ");
            }
            break;
            default:
                throw new IllegalArrayType("Wrong array type: " + type);
        }
        List<String> list = CustomParser.getInstance().divideToSubStrings(str);

        for (String number : list) {
            if (!NumberUtils.isParsable(number)) {
                return false;
            }
        }
        return true;
    }
}
