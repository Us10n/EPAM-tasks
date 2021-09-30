package com.epamjwd.task1;

import com.epamjwd.task1.entity.CustomArray;
import com.epamjwd.task1.entity.DoubleArray;
import com.epamjwd.task1.exceptions.FileCloceException;
import com.epamjwd.task1.exceptions.FileOpenException;
import com.epamjwd.task1.exceptions.IllegalArrayType;
import com.epamjwd.task1.factory.ArrayType;
import com.epamjwd.task1.parser.CustomParser;
import com.epamjwd.task1.reader.CustomReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String path = "./src/main/resources/nums.txt";

    public static void main(String[] args) throws FileOpenException, FileCloceException, IllegalArrayType {
        String[] fileStrings = CustomReader.getInstance().readAll(path);

        List<DoubleArray> doubleArrayList = new ArrayList();
        for (String fileString : fileStrings) {
            CustomArray customArray;
            customArray = CustomParser.getInstance().convertStringToCustomArray(fileString, ArrayType.DoubleArray);
            if(customArray==null){
                continue;
            }
            doubleArrayList.add(customArray.doubleArray());
        }
        System.out.println(doubleArrayList);



    }
}
