package com.epamjwd.task1.reader;

import com.epamjwd.task1.exception.CustomFileException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CustomReaderTest{

   static CustomReader reader;

    @BeforeClass
    public static void setUp() {
        reader = new CustomReader();
    }

    @Test
    public void testReadAllSuccess() throws CustomFileException {
        String path = "./src/test/resources/data/test.txt";
        List<String> expected = Arrays.asList("1.213 .1234 21.11",
                "213..123..123.12.3.21.3",
                "3432432.234234.",
                "awdawdawdawd");
        List<String> actual = reader.readAll(path);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = CustomFileException.class)
    public void testReadAllCustomException() throws CustomFileException {
        String path = "1";
        reader.readAll(path);
    }
}