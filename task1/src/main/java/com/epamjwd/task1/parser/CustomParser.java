package com.epamjwd.task1.parser;


import com.epamjwd.task1.entity.CustomArray;
import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exceptions.IllegalArrayType;
import com.epamjwd.task1.factory.ArrayType;
import com.epamjwd.task1.factory.CustomFactory;
import com.epamjwd.task1.validator.CustomValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomParser {
    private static CustomParser instance;

    public static CustomParser getInstance() {
        if (instance == null) {
            instance = new CustomParser();
        }
        return instance;
    }

    /*
      Methode divides String(str) to List of String with numbers
    */
    public List<String> divideToSubStrings(String str) {
        Scanner scanner = new Scanner(str);
        List<String> list = new ArrayList();

        while (scanner.hasNext()) {
            String next = scanner.next();
            list.add(next);
        }
        return list;
    }

    public CustomArray convertStringToCustomArray(String str, ArrayType type) throws NumberFormatException, IllegalArrayType {
        if (!CustomValidator.getInstance().isTextLineValid(str, type)) {
            return null;
        }

        List<Object> arrayofNumbers = new ArrayList();
        CustomArray customArray = CustomFactory.getInstance().createArray(type);
        str = str.replaceAll(", +"," ");
        List<String> numbers = CustomParser.getInstance().divideToSubStrings(str);
        for (String fstring : numbers) {
            arrayofNumbers.add(Double.parseDouble(fstring));
        }
        switch (type) {
            case DoubleArray: {
                DoubleArray toReturn = customArray.doubleArray();
                toReturn.setArray(arrayofNumbers.toArray(new Double[0]));
                return toReturn;
            }
            default: {
                throw new IllegalArrayType("Wrong array type: " + type);
            }
        }
    }
}
