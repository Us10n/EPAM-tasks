package com.epamjwd.lab0.validator;

import com.epamjwd.lab0.parser.CustomParser;
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

    public boolean isTextLineValid(String str) {
        List<String> list=CustomParser.getInstance().divideToStrings(str);

        for(String number: list){
            if(!NumberUtils.isCreatable(number)){
                return false;
            }
        }
        return true;
    }
}
