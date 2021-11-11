package com.epamjwd.task4.reader;

import com.epamjwd.task4.exception.FileException;
import com.epamjwd.task4.reader.impl.CustomReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomReaderTest {
    String validFileName= "/data/test.txt";
    String invalidFileName= "/data/teawd.txt";

    @Test
    public void testReadAll() throws FileException {
        CustomReaderImpl reader=new CustomReaderImpl();
        String text=reader.readAll(validFileName);
        int expected=780;
        int actual=text.length();
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = FileException.class)
    public void testReadException() throws FileException{
        CustomReaderImpl reader=new CustomReaderImpl();
        String text=reader.readAll(invalidFileName);
    }
}