package com.epamjwd.lab0;

import com.epamjwd.lab0.entity.CustomNumber;
import com.epamjwd.lab0.exception.CustomFileException;
import com.epamjwd.lab0.parser.CustomParser;
import com.epamjwd.lab0.reader.CustomReader;
import com.epamjwd.lab0.service.CustomOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger Log = LogManager.getLogger();
    private static final String path = "./src/main/resources/numbers.txt";

    public static void main(String[] args) throws CustomFileException {
        CustomReader customReader = new CustomReader();
        List<String> stringList = customReader.readAll(path);

        List<CustomNumber> customNumberList = new ArrayList<>();
        stringList.forEach(line -> {
            customNumberList.addAll(CustomParser.getInstance().convertStringToCustomNumberList(line));
        });

        CustomOperations customOperations = new CustomOperations();
        Log.info("Addition result: " + customOperations.add(customNumberList));
        Log.info("Subtraction result: " + customOperations.sub(customNumberList));
        Log.info("Multiplication result: " + customOperations.mul(customNumberList));
        Log.info("Division result: " + customOperations.div(customNumberList));
    }
}
