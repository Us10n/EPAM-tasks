package com.epamjwd.task1.reader;

import com.epamjwd.task1.exceptions.FileCloceException;
import com.epamjwd.task1.exceptions.FileOpenException;
import com.epamjwd.task1.parser.CustomParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomReader {
    private static CustomReader instance;
    private BufferedReader bReader;

    public static CustomReader getInstance() {
        if (instance == null) {
            instance = new CustomReader();
        }
        return instance;
    }

    public String[] readAll(String filepath) throws FileOpenException, FileCloceException {
        initReader(filepath);

        List<String> result = new ArrayList<>();
        String line;

        try {
            while ((line = bReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new FileOpenException("File read exception " + e.getMessage());
        } finally {
            try {
                bReader.close();
            } catch (IOException e) {
                throw new FileCloceException("File close exception " + e.getMessage());
            }
        }
        return result.toArray(new String[0]);
    }

    private void initReader(String filepath) throws FileOpenException {
        try {
            this.bReader = new BufferedReader(new FileReader(filepath));
        } catch (FileNotFoundException e) {
            throw new FileOpenException("Reader init exception " + e.getMessage());
        }
    }
}
