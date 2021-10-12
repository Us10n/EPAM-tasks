package com.epamjwd.task2.reader.impl;

import com.epamjwd.task2.exception.CustomFileException;
import com.epamjwd.task2.reader.CustomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReaderImpl implements CustomReader {

    public List<String> readAll(String filepath) throws CustomFileException {
        List<String> fileLines;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            fileLines = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new CustomFileException(e);
        }
        return fileLines;
    }

}
