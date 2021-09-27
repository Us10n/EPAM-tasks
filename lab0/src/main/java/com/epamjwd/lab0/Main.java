package com.epamjwd.lab0;

import com.epamjwd.lab0.entity.CustomNumber;
import com.epamjwd.lab0.parser.CustomParser;
import com.epamjwd.lab0.reader.Reader;
import com.epamjwd.lab0.service.CustomOperations;
import com.epamjwd.lab0.validator.CustomValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOG = LogManager.getLogger();
    private static final String path = "C:\\Users\\Us10n\\IdeaProjects\\lab0\\src\\main\\resources\\numbers.txt   ";
    private static final File file = new File(path);

    public static void main(String args[]) {
        Reader reader;
        String msg = "";
        try {
            reader = new Reader(file);
            msg = reader.readAll();
            reader.close();
        } catch (FileNotFoundException e) {
            LOG.error("Reader exception while initialization" + e.getMessage());
        } catch (IOException e) {
            LOG.error("Reader exception while reading/closing" + e.getMessage());
        }

        if (!CustomValidator.getInstance().isTextLineValid(msg)) {
            LOG.error("File string is not valid");
            return;
        }

        List<String> listOfStrings = CustomParser.getInstance().divideToStrings(msg);
        List<CustomNumber> listOfCustomNumbers = new ArrayList();
        for (String str : listOfStrings) {
            CustomNumber number = CustomParser.getInstance().convertToCustomNumber(str);
            listOfCustomNumbers.add(number);
        }

        LOG.info(CustomOperations.getInstance().add(listOfCustomNumbers));
        LOG.info(CustomOperations.getInstance().sub(listOfCustomNumbers));
        LOG.info(CustomOperations.getInstance().mul(listOfCustomNumbers));
        LOG.info(CustomOperations.getInstance().div(listOfCustomNumbers));
    }
}
