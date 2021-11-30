package com.epamjwd.task5.reader.impl;

import com.epamjwd.task5.exception.FileException;
import com.epamjwd.task5.reader.CustomReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReaderImpl implements CustomReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readAll(String fileName) throws FileException {
        URL resourceUrl = this.getClass().getResource(fileName);

        if (resourceUrl == null) {
            logger.error("File with name" + fileName + " wasn't found");
            throw new FileException("File with name :" + fileName + " wasn't found");
        }

        String filePath = resourceUrl.getPath();
        List<String> fileLines;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            fileLines = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileException(e);
        }

        return fileLines;
    }
}
