package com.epamjwd.lab0.parser;


import com.epamjwd.lab0.entity.CustomNumber;
import com.epamjwd.lab0.factory.CustomFactory;
import com.epamjwd.lab0.factory.NumberTypes;

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
    public List<String> divideToStrings(String str) {
        Scanner scanner = new Scanner(str);
        List<String> list=new ArrayList();

        while (scanner.hasNext()) {
            String next=scanner.next();
            list.add(next);
        }
        return list;
    }

    public CustomNumber convertToCustomNumber(String str) throws NumberFormatException{
        CustomNumber customNumber=CustomFactory.getInstance().getNumber(NumberTypes.CustomNumber);
        customNumber.setValue(Double.parseDouble(str));
        return customNumber;
    }
}
