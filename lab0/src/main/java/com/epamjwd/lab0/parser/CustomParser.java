package com.epamjwd.lab0.parser;


import com.epamjwd.lab0.entity.CustomNumber;

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
        return new CustomNumber(Double.parseDouble(str));
    }
}
