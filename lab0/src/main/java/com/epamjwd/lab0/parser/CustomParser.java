package com.epamjwd.lab0.parser;


import com.epamjwd.lab0.entity.CustomNumber;
import com.epamjwd.lab0.factory.CustomFactory;
import com.epamjwd.lab0.validator.CustomValidator;

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
        List<String> list=new ArrayList();

        while (scanner.hasNext()) {
            String next=scanner.next();
            list.add(next);
        }
        return list;
    }

    public List<CustomNumber> convertStringToCustomNumberList(String str) {
        if (!CustomValidator.getInstance().isTextLineValid(str)) {
            return null;
        }
        List<CustomNumber> customNumberList=new ArrayList<>();
        List<String> numbers = divideToSubStrings(str);
        for (String number : numbers) {
            Double parsedNumber=Double.parseDouble(number);
            CustomNumber customNumber=CustomFactory.getInstance().getNumber(parsedNumber);
            customNumberList.add(customNumber);
        }

        return customNumberList;

    }
}
