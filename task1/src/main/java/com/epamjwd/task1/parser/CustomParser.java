package com.epamjwd.task1.parser;


import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.factory.CustomFactory;
import com.epamjwd.task1.validator.CustomValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomParser {
    private static CustomParser instance;

    public static CustomParser getInstance() {
        if (instance == null) {
            instance = new CustomParser();
        }
        return instance;
    }

    public Optional<DoubleArray> convertStringToDoubleArray(String str) {
        if (!CustomValidator.getInstance().isTextLineValid(str)) {
            return Optional.empty();
        }

        List<Double> doubleList = new ArrayList();
        List<String> numbers = divideToSubStrings(str);
        for (String number : numbers) {
            doubleList.add(Double.parseDouble(number));
        }
        DoubleArray doubleArray=CustomFactory.getInstance().createArray(doubleList.toArray(new Double[0]));

        return Optional.ofNullable(doubleArray);

    }

    private List<String> divideToSubStrings(String str) {
        Scanner scanner = new Scanner(str);
        List<String> list = new ArrayList();

        while (scanner.hasNext()) {
            String next = scanner.next();
            list.add(next);
        }
        return list;
    }
}

