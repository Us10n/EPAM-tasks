package com.epamjwd.task1.reader;

import com.epamjwd.task1.exception.CustomFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReader {

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
