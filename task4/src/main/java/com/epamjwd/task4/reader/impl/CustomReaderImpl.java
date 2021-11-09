package com.epamjwd.task4.reader.impl;

import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.reader.CustomReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

public class CustomReaderImpl implements CustomReader {
    private static final Logger logger = LogManager.getLogger();

    public String readAll(String fileName) throws FileException {
        URL resourceUrl = this.getClass().getResource(fileName);
        if (resourceUrl == null) {
            logger.error("File with name" + fileName + " wasn't found");
            throw new FileException("File with name :" + fileName + " wasn't found");
        }

        String filePath = resourceUrl.getPath();
        String fileText;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            fileText = bufferedReader.lines().collect(Collectors.joining("\r\n"));
        } catch (IOException e) {
            throw new FileException(e);
        }


        return fileText;
    }

}
