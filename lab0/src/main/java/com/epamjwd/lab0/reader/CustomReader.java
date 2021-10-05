package com.epamjwd.lab0.reader;

import com.epamjwd.lab0.exception.CustomFileException;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CustomReader {
    public List<String> readAll(String filepath) throws CustomFileException {
        List<String> fileLines = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            fileLines = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new CustomFileException(e);
        }
        return fileLines;
    }
}
