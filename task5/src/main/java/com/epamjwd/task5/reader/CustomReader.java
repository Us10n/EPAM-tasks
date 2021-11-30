package com.epamjwd.task5.reader;

import com.epamjwd.task5.exception.FileException;

import java.util.List;

public interface CustomReader {
    List<String> readAll(String filepath) throws FileException;
}
