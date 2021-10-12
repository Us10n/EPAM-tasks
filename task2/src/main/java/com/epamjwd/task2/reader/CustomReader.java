package com.epamjwd.task2.reader;

import com.epamjwd.task2.exception.CustomFileException;

import java.util.List;

public interface CustomReader {
    List<String> readAll(String filepath) throws CustomFileException;
}
