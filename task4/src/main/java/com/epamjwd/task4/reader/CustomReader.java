package com.epamjwd.task4.reader;

import com.epamjwd.task4.exception.FileException;

import java.util.List;

public interface CustomReader {
    String readAll(String filepath) throws FileException;
}
