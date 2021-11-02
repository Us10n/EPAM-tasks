package com.epamjwd.task2.reader.impl;

import com.epamjwd.task2.exception.CustomFileException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomReaderImplTest {

    @Test
    public void testReadAll() throws CustomFileException {
        CustomReaderImpl reader = new CustomReaderImpl();
        String filePath = "/data/testfile.txt";
        List<String> expected = new ArrayList<>();
        expected.add("[1.a1 1.1 1.1], awd], [1.1 1.1 1.1], [1.1 1.1 1.1], [1.1 1.1 1.1], [1.1 1.1 1.1]");
        expected.add("");
        expected.add("[3. 0. 0.] 2.");
        expected.add("[1. 2. -22.] 3.");
        expected.add("[-1. 1. 4.] 1.");
        List<String> actual = reader.readAll(filePath);
        Assert.assertEquals(actual,expected);
    }
}